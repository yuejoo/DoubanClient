package com.dependentservices.douban.invoker.http;

import com.dependentservices.douban.model.immutabales.HttpBatchResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.concurrent.ExecutionException;

public interface HttpBatch {
    void addRequest(HttpRequestBase httpRequest);
    HttpBatchResponse callSync() throws InterruptedException, ExecutionException;
}
