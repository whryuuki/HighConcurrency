package com.mmall.concurrency.example.wxmini;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
 
/**
 * 微信登录配置
 * @author Lion Li
 * @version 2019-4-19
 */
@Component
@Configuration
public class WXLoginConfig {
 
    @Value("${wx.appid:wxa430b4cfb9826f1a}")
    private String appid;
    @Value("${wx.secret:400ac4628f955cb1de3ade5a0560ca1a}")
    private String secret;
 
    public String WXLoginAuth(String code){
        // 获取微信传入的code拼接http鉴权参数
        return "appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
    }
 
}