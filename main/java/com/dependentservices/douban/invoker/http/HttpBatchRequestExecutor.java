package com.dependentservices.douban.invoker.http;

import com.dependentservices.douban.model.immutabales.HttpBatchResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.concurrent.ExecutionException;

public interface HttpBatchRequestExecutor
{
    void addRequest(HttpRequestBase httpRequest);
    HttpBatchResponse execute() throws InterruptedException, ExecutionException;
}
