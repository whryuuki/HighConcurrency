package com.mmall.concurrency.example.wxmini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 微信登录service
 * 
 * @author Lion Li
 * @version 2019-4-19
 */
@Service
public class WXLoginService {
	@Autowired
	private WXLoginConfig wxLoginConfig;

	@Value("${wx.authUrl:https://api.weixin.qq.com/sns/jscode2session}")
	private String authUrl;

	public String getWXLoginAuth(String code) {
		return HttpUtils.sendGet(authUrl, wxLoginConfig.WXLoginAuth(code));
	}

	public String getUserInfo(String sessionKey,String encryptedData,String iv) {
		WXBizDataCrypt biz = new WXBizDataCrypt("wxa430b4cfb9826f1a", sessionKey);
		return biz.decryptData(encryptedData, iv);
	}

}