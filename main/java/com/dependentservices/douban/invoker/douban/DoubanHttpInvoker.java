package com.dependentservices.douban.invoker.douban;

import com.dependentservices.douban.model.immutabales.DoubanRequest;
import com.dependentservices.douban.model.immutabales.DoubanResponse;

public interface DoubanHttpInvoker
{
    DoubanResponse invoke(DoubanRequest request);
}
