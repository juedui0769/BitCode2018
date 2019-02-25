package com.wxg.baidu.fanyi.info;

/**
 * 百度翻译API，申请信息，包含APPID和密钥
 */
public class SecretInfo {
    private String appId;
    private String secretKey;

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
