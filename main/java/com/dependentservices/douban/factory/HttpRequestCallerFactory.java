package com.dependentservices.douban.factory;

public interface HttpRequestCallerFactory<CLIENT, REQUEST, RESPONSE>
{
    RESPONSE create(CLIENT client, REQUEST request);
}
