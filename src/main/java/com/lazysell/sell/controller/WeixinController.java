package com.lazysell.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeixinController
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.controller
 * Created by Lazy on 2017/11/13 18:07
 * Version: 0.1
 * Info: @TODO:...
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @RequestMapping("/authorize")
    public void authorize(String code){
        log.error("进入authorize 方法。。。code={}",code);
    }
}
