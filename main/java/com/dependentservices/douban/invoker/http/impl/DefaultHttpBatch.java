package com.dependentservices.douban.invoker.http.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.dependentservices.douban.factory.HttpClientFactory;
import com.dependentservices.douban.factory.HttpRequestCallerFactory;
import com.dependentservices.douban.invoker.http.HttpBatch;
import com.dependentservices.douban.invoker.http.HttpRequestCaller;
import com.dependentservices.douban.model.immutabales.HttpBatchResponse;
import com.dependentservices.douban.model.immutabales.ImmutableHttpBatchResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

public class DefaultHttpBatch implements HttpBatch
{
    @Override
    public void addRequest(final HttpRequestBase httpRequest)
    {
        requests.add(httpRequest);
    }

    @Override
    public HttpBatchResponse callSync() throws InterruptedException, ExecutionException
    {
        final List batch = requests.stream().map(req -> httpRequestCallerFactory.create(httpClientFactory.create(), req)).collect(Collectors.toList());

        final List<Future<HttpResponse>> responses = executorService.invokeAll(batch);

        final ImmutableHttpBatchResponse.Builder builder = ImmutableHttpBatchResponse.builder();

        for(final Future<HttpResponse> futureResponse : responses)
        {
            builder.addBatchResponse(futureResponse.get());
        }

        return builder.build();
    }

    public DefaultHttpBatch(final ExecutorService executorService, final HttpClientFactory httpClientFactory, final HttpRequestCallerFactory httpRequestCallerFactory)
    {
        this.executorService = executorService;
        this.httpRequestCallerFactory = httpRequestCallerFactory;
        this.httpClientFactory = httpClientFactory;
        this.requests = new LinkedList<>();
    }

    private final ExecutorService executorService;
    private final HttpRequestCallerFactory<HttpClient, HttpRequestBase, HttpRequestCaller> httpRequestCallerFactory;
    private final HttpClientFactory httpClientFactory;
    private final List<HttpRequestBase> requests;
}
