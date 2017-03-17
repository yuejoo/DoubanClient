package com.application;

import com.dependentservices.douban.factory.HttpBatchRequestExecutorFactory;
import com.dependentservices.douban.factory.HttpClientFactory;
import com.dependentservices.douban.factory.HttpRequestCallerFactory;
import com.dependentservices.douban.factory.impl.DefaulHttpRequestCallerFactory;
import com.dependentservices.douban.factory.impl.DefaultHttpBatchRequestExecutorFactory;
import com.dependentservices.douban.factory.impl.DefaultHttpClientFactory;
import com.dependentservices.douban.invoker.douban.DoubanHttpInvoker;
import com.dependentservices.douban.invoker.douban.impl.DefaultDoubanHttpInvoker;
import com.dongxuexidu.douban4j.service.DoubanBookMovieMusicService;
import com.dongxuexidu.douban4j.service.DoubanCollectionService;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;


@Configuration
public class DoubanServiceConfig
{
  @Bean
  public DoubanBookMovieMusicService doubanBookMovieMusicService()
  {
    return new DoubanBookMovieMusicService();
  }

  @Bean
  public DoubanCollectionService doubanCollectionService()
  {
    return new DoubanCollectionService();
  }

  @Bean
  public HttpRequestCallerFactory httpRequestCallerFactory() { return new DefaulHttpRequestCallerFactory(); }

  @Bean
  public HttpClientFactory httpClientFactory() { return new DefaultHttpClientFactory(); }

  @Bean
  public HttpBatchRequestExecutorFactory httpBatchRequestExecutorFactory()
  {
    return new DefaultHttpBatchRequestExecutorFactory(Executors.newCachedThreadPool(), httpClientFactory(), httpRequestCallerFactory());
  }

  @Bean
  public DoubanHttpInvoker doubanHttpInvoker()
  {
    return new DefaultDoubanHttpInvoker(httpBatchRequestExecutorFactory());
  }
}
