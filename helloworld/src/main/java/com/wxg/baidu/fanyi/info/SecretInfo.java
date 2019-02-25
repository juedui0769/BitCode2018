package com.wxg.baidu.fanyi.info;

/**
 * 百度翻译API，申请信息，包含APPID和密钥
 *
 * 2019年2月25日13:18:11，字段添加上了`transient`关键字
 *
 */
public class SecretInfo {
    private transient String appId;
    private transient String secretKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "SecretInfo{" +
                "appId='" + appId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
