package com.dependentservices.douban.invoker.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.concurrent.Callable;

public class HttpRequestCaller implements Callable<HttpResponse>
{
    @Override
    public HttpResponse call() throws IOException
    {
        System.out.println("Start Call");
        final HttpResponse httpResponse = httpClient.execute(httpRequest);
        System.out.println("End Call");
        return httpResponse;
    }

    public HttpRequestCaller(final HttpClient httpClient, final HttpRequestBase httpRequest)
    {
        this.httpClient = httpClient;
        this.httpRequest = httpRequest;
    }

    private final HttpRequestBase httpRequest;
    private final HttpClient httpClient;
}
