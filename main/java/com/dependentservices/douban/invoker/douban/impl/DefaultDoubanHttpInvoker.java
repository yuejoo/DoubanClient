package com.dependentservices.douban.invoker.douban.impl;

import com.dependentservices.douban.factory.HttpBatchRequestExecutorFactory;
import com.dependentservices.douban.invoker.douban.DoubanHttpInvoker;
import com.dependentservices.douban.invoker.http.HttpBatchRequestExecutor;
import com.dependentservices.douban.model.immutabales.DoubanRequest;
import com.dependentservices.douban.model.immutabales.DoubanResponse;
import com.dependentservices.douban.model.immutabales.ImmutableDoubanResponse;
import org.apache.http.client.methods.HttpRequestBase;

public final class DefaultDoubanHttpInvoker implements DoubanHttpInvoker
{
    @Override
    public DoubanResponse invoke(final DoubanRequest doubanRequest)
    {
        final HttpBatchRequestExecutor executor = httpBatchRequestExecutorFactory.create();

        for(final HttpRequestBase httpRequest : doubanRequest.getHttpRequests())
        {
            executor.addRequest(httpRequest);
        }

        final ImmutableDoubanResponse.Builder builder = ImmutableDoubanResponse.builder();

        try
        {
            builder.addAllHttpResponse(executor.execute().getBatchResponse());
        }
        catch (Exception e)
        {
            //Todo Handle Something here.

        }

        return builder.build();
    }

    public DefaultDoubanHttpInvoker(final HttpBatchRequestExecutorFactory httpBatchRequestExecutorFactory)
    {
        this.httpBatchRequestExecutorFactory = httpBatchRequestExecutorFactory;
    }

    private final HttpBatchRequestExecutorFactory httpBatchRequestExecutorFactory;
}
