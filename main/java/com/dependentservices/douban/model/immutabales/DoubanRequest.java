package com.dependentservices.douban.model.immutabales;

import java.util.List;
import org.apache.http.client.methods.HttpRequestBase;
import org.immutables.value.Value;

@Value.Immutable
public abstract class DoubanRequest {
    public abstract List<HttpRequestBase> getHttpRequests();
}

