package com.dependentservices.douban.request.factory;

import com.dongxuexidu.douban4j.provider.OAuthDoubanProvider;

public interface OAuthDoubanProviderFactory
{
    OAuthDoubanProvider create();
}
