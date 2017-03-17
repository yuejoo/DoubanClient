package com.dependentservices.douban.invoker.douban;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.dependentservices.douban.factory.HttpRequestCallerFactory;
import com.dependentservices.douban.invoker.http.HttpBatch;
import com.dependentservices.douban.invoker.http.HttpRequestCaller;
import com.dependentservices.douban.invoker.http.impl.DefaultHttpBatch;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RunWith(MockitoJUnitRunner.class)
public class HttpBatchTest {

    @Test
    public void testCreate() throws InterruptedException, ExecutionException
    {
        final ExecutorService executorService = mock(ExecutorService.class);
        final HttpClient httpClient = mock(HttpClient.class);
        final HttpRequestCallerFactory<HttpClient, HttpRequestBase, HttpRequestCaller> httpRequestCallerFactory = mock(HttpRequestCallerFactory.class);
        final HttpRequestCaller httpRequestCaller = mock(HttpRequestCaller.class);
        final HttpRequestBase httpRequestBase = mock(HttpRequestBase.class);

        when(httpRequestCallerFactory.create(httpClient, httpRequestBase)).thenReturn(httpRequestCaller);

        final List batch = new ArrayList<>();

        batch.add(httpRequestCaller);

        final Future<HttpResponse> futureResponse = mock(Future.class);
        final HttpResponse httpResponse = mock(HttpResponse.class);
        when(futureResponse.get()).thenReturn(httpResponse);

        final List<Future<HttpResponse>> httpResponseFutureList = new LinkedList<>();
        httpResponseFutureList.add(futureResponse);

        when(executorService.invokeAll(batch)).thenReturn(httpResponseFutureList);

        final HttpBatch httpBatch = new DefaultHttpBatch(executorService, httpClient, httpRequestCallerFactory);
        httpBatch.addRequest(httpRequestBase);

        assertEquals(httpBatch.callSync().getBatchResponse().get(0), httpResponse);
    }
}
