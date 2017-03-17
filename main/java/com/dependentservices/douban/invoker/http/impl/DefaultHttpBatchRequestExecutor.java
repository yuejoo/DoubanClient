package com.dependentservices.douban.invoker.http.impl;

import com.dependentservices.douban.invoker.http.HttpBatchRequestExecutor;
import com.dependentservices.douban.invoker.http.HttpBatch;
import com.dependentservices.douban.model.immutabales.HttpBatchResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.concurrent.ExecutionException;

public class DefaultHttpBatchRequestExecutor implements HttpBatchRequestExecutor
{
    @Override
    public HttpBatchResponse execute() throws InterruptedException, ExecutionException
    {
        return httpBatch.callSync();
    }

    @Override
    public void addRequest(final HttpRequestBase httpRequest)
    {
        this.httpBatch.addRequest(httpRequest);
    }

    public DefaultHttpBatchRequestExecutor(final HttpBatch httpBatch)
    {
        this.httpBatch = httpBatch;
    }

    private final HttpBatch httpBatch;
}
