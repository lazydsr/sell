package com.lazysell.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * WechatAccountConfig
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.config
 * Created by Lazy on 2017/11/13 12:11
 * Version: 0.1
 * Info: @TODO:...
 */
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;
}
