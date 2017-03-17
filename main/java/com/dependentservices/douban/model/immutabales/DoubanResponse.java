package com.dependentservices.douban.model.immutabales;

import org.apache.http.HttpResponse;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public abstract class DoubanResponse {
    public abstract List<HttpResponse> getHttpResponse();
}