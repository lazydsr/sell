package com.lazysell.sell.controller;

import com.lazysell.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * WechatController
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.controller
 * Created by Lazy on 2017/11/13 12:13
 * Version: 0.1
 * Info: @TODO:...
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {
    @Autowired
    private WxMpService wxMpService;
    @GetMapping("/authorize")
    public String authorize(String returnUrl){
        String url="http://w6hmms.natappfree.cc/sell/wechat/userInfo";
        String code = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        log.info("[微信网页授权] 获取code={}",code);
        return "redirect:"+code;
    }

    @RequestMapping("/userInfo")
    public String userInfo(String code,String state){
        WxMpOAuth2AccessToken accessToken=null;
        try {
            accessToken= wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("微信  错误{}",e);
            throw new SellException(20,e.getError().getErrorMsg());
        }
        String openId = accessToken.getOpenId();
        return "redirect:"+state+"?openid="+openId;
    }
}
