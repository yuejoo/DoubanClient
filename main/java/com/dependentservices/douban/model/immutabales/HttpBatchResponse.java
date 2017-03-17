package com.dependentservices.douban.model.immutabales;

import java.util.List;
import org.apache.http.HttpResponse;
import org.immutables.value.Value;

@Value.Immutable
public abstract class HttpBatchResponse {
    public abstract List<HttpResponse> getBatchResponse();
}
