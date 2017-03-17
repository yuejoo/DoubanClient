package com.dependentservices.douban.request.factory.impl;

import com.dependentservices.douban.request.factory.OAuthDoubanProviderFactory;
import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.app.RequestGrantScope;
import com.dongxuexidu.douban4j.provider.OAuthDoubanProvider;

public final class DefaultOAuthDoubanProviderFactory implements OAuthDoubanProviderFactory
{
    @Override
    public OAuthDoubanProvider create()
    {
        OAuthDoubanProvider oauth = new OAuthDoubanProvider();
        oauth.setApiKey(DefaultConfigs.API_KEY).setSecretKey(DefaultConfigs.SECRET_KEY);
        oauth.addScope(RequestGrantScope.BASIC_COMMON_SCOPE);
        oauth.setRedirectUrl(DefaultConfigs.ACCESS_TOKEN_REDIRECT_URL);

        return oauth;
    }
}
