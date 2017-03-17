package com.dependentservices.douban.factory;

import org.apache.http.client.HttpClient;

public interface HttpClientFactory
{
    HttpClient create();
}
