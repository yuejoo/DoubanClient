package com.dependentservices.douban.model.immutabales;

import org.immutables.value.Value;

@Value.Immutable
public abstract class HttpRequestId {
    public abstract String getId();
}
