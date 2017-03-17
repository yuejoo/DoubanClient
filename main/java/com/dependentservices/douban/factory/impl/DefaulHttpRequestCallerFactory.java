package com.dependentservices.douban.factory.impl;

import com.dependentservices.douban.factory.HttpRequestCallerFactory;
import com.dependentservices.douban.invoker.http.HttpRequestCaller;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

public class DefaulHttpRequestCallerFactory implements HttpRequestCallerFactory<HttpClient, HttpRequestBase, HttpRequestCaller>
{
    @Override
    public HttpRequestCaller create(HttpClient client, HttpRequestBase request)
    {
        return new HttpRequestCaller(client, request);
    }
}
