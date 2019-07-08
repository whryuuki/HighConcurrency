package com.mmall.concurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmall.concurrency.example.wxmini.WXLoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {

	@Autowired
	private WXLoginService wxLoginService;
	
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
    
    @RequestMapping("/wx/getSession")
    @ResponseBody
    public String wxGetSession(String code) {
    	String re = wxLoginService.getWXLoginAuth(code);
    	return re;
    }
    
    @PostMapping("/wx/getUserInfo")
    @ResponseBody
    public String getUserInfo(String sessionKey,String encryptedData,String iv) {
    	log.info("ss");
    	String re = wxLoginService.getUserInfo(sessionKey, encryptedData, iv);
    	return re;
    }
    
}
