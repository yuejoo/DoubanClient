package com.dependentservices.douban.factory.impl;

import com.dependentservices.douban.factory.HttpClientFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class DefaultHttpClientFactory implements HttpClientFactory
{
    @Override
    public HttpClient create()
    {
        return HttpClientBuilder.create().build();
    }
}
