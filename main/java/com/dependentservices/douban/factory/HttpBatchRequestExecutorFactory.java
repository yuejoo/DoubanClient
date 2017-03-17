package com.dependentservices.douban.factory;

import com.dependentservices.douban.invoker.http.HttpBatchRequestExecutor;

public interface HttpBatchRequestExecutorFactory {
    HttpBatchRequestExecutor create();
}
