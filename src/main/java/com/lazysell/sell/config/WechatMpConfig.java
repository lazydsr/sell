package com.lazysell.sell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * WechatMpConfig
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.config
 * Created by Lazy on 2017/11/13 12:19
 * Version: 0.1
 * Info: @TODO:...
 */
@Component
public class WechatMpConfig {
    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Bean
    public WxMpService wxMpService() {
        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage mpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        mpInMemoryConfigStorage.setAppId(wechatAccountConfig.getMpAppId());
        mpInMemoryConfigStorage.setSecret(wechatAccountConfig.getMpAppSecret());
        return mpInMemoryConfigStorage;
    }
}
