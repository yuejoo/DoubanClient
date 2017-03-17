package com.application.controller;

import com.application.DoubanServiceConfig;
import com.dependentservices.douban.invoker.douban.DoubanHttpInvoker;
import com.dependentservices.douban.model.immutabales.*;
import com.dependentservices.douban.model.immutabales.ImmutableDoubanRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOAuthCode{

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam("isbn")final String isbn) {

       final HttpGet httpRequest3 = new HttpGet("https://api.douban.com/v2/book/"+ isbn);
       final HttpGet httpRequest2 = new HttpGet("http://imdb.wemakesites.net/api/nm0000314?api_key=06170c67-192f-40a2-85fe-e6cf31827c64");
       final ImmutableDoubanRequest doubanRequest = ImmutableDoubanRequest.builder()
               .addHttpRequests(httpRequest3).build();

       final DoubanHttpInvoker httpInvoker = config.getBean(DoubanHttpInvoker.class);


       String output = "";
       try {
           long startTime = System.currentTimeMillis();
           DoubanResponse response = httpInvoker.invoke(doubanRequest);
           long endTime = System.currentTimeMillis();
           Long elaps = (endTime - startTime);
           output = elaps.toString() + EntityUtils.toString(response.getHttpResponse().get(0).getEntity());
       }
       catch (Exception e)
        {

        }
       return "Hello World " + output;
    }

    private final static org.springframework.context.ApplicationContext config = new AnnotationConfigApplicationContext(DoubanServiceConfig.class);
}

