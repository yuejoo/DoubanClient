package com.dependentservices.douban.factory.impl;

import com.dependentservices.douban.factory.HttpBatchRequestExecutorFactory;
import com.dependentservices.douban.factory.HttpClientFactory;
import com.dependentservices.douban.factory.HttpRequestCallerFactory;
import com.dependentservices.douban.invoker.http.HttpBatchRequestExecutor;
import com.dependentservices.douban.invoker.http.HttpRequestCaller;
import com.dependentservices.douban.invoker.http.impl.DefaultHttpBatch;
import com.dependentservices.douban.invoker.http.impl.DefaultHttpBatchRequestExecutor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.concurrent.ExecutorService;

public class DefaultHttpBatchRequestExecutorFactory implements HttpBatchRequestExecutorFactory
{
    @Override
    public HttpBatchRequestExecutor create()
    {
        return new DefaultHttpBatchRequestExecutor(new DefaultHttpBatch(executorService, httpClientFactory, httpRequestCallerFactory));
    }

    public DefaultHttpBatchRequestExecutorFactory(final ExecutorService executorService, final HttpClientFactory httpClientFactory, final HttpRequestCallerFactory httpRequestCallerFactory)
    {
        this.executorService = executorService;
        this.httpRequestCallerFactory = httpRequestCallerFactory;
        this.httpClientFactory = httpClientFactory;
    }

    private final HttpClientFactory httpClientFactory;
    private final ExecutorService executorService;
    private final HttpRequestCallerFactory<HttpRequestBase, HttpClient, HttpRequestCaller> httpRequestCallerFactory;
}
