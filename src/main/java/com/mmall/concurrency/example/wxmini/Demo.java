package com.mmall.concurrency.example.wxmini;
/**
 * 用户加密数据的解密
 *
 * @author Lion Li
 * @version 2019-4-19
 */
public class Demo {
 
    public static void main(String[] args) {
        // 微信应用id
        String appId = "wxa430b4cfb9826f1a";
        // 从微信接口获取(https://api.weixin.qq.com/sns/jscode2session) 类似token 有时效性
        String sessionKey = "XXXXXXXXXXXXXXXXX";
        // 加密数据
        String encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZM"
                + "QmRzooG2xrDcvSnxIMXFufNstNGTyaGS"
                + "9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+"
                + "3hVbJSRgv+4lGOETKUQz6OYStslQ142d"
                + "NCuabNPGBzlooOmB231qMM85d2/fV6Ch"
                + "evvXvQP8Hkue1poOFtnEtpyxVLW1zAo6"
                + "/1Xx1COxFvrc2d7UL/lmHInNlxuacJXw"
                + "u0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn"
                + "/Hz7saL8xz+W//FRAUid1OksQaQx4CMs"
                + "8LOddcQhULW4ucetDf96JcR3g0gfRK4P"
                + "C7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB"
                + "6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns"
                + "/8wR2SiRS7MNACwTyrGvt9ts8p12PKFd"
                + "lqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYV"
                + "oKlaRv85IfVunYzO0IKXsyl7JCUjCpoG"
                + "20f0a04COwfneQAGGwd5oa+T8yO5hzuy"
                + "Db/XcxxmK01EpqOyuxINew==";
        // 偏移量
        String iv = "XXXXXXXXXXXXXXXXX";
        // 新建解密工具
        WXBizDataCrypt biz = new WXBizDataCrypt(appId, sessionKey);
        // 调用解密方法
        System.out.println(biz.decryptData(encryptedData, iv));
 
    }
}