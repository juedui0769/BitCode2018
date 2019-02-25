package com.wxg.baidu.fanyi;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.wxg.baidu.fanyi.exception.BaiduFanyiException;
import com.wxg.baidu.fanyi.info.SecretInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 2019年2月25日23:30:07，
 *      - 将`client`移到 {@link com.wxg.okhttp.util.ClientUtils} 中后
 *      - 这个类就可以与 {@link BaiduFanyi} 合并
 *      -
 *
 */
public class BaiduTranslate {

    private static volatile BaiduTranslate instance;

    // 百度翻译API，申请信息
    private SecretInfo secretInfo;

    private static String localFilePath;

    private BaiduTranslate() {}

    public static void setSecretInfoStorePath(String secretInfoStorePath) {
        localFilePath = secretInfoStorePath;
    }

    public static boolean isInit() {
        return instance == null ? false : true;
    }

    public synchronized static BaiduTranslate getInstance() {
        if (instance == null) {
            if (localFilePath == null) {
                throw new BaiduFanyiException("请先设置'申请信息'在本地的存储位置, `setSecretInfoStorePath(...)`");
            }
            instance = new BaiduTranslate();
            SecretInfo secretInfo = instance.getIdAndSecretkeyFromLocalFile(localFilePath);
            instance.setSecretInfo(secretInfo);

        }
        return instance;
    }

    private SecretInfo getIdAndSecretkeyFromLocalFile(String filepath) {
        SecretInfo secretInfo = null;

        if (filepath == null) {
            throw new BaiduFanyiException("没有提供`filepath`");
        }
        List<String> lines = null;
        try {
            lines = Files.readLines(new File(filepath), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null && lines.size() >= 2){
            secretInfo = new SecretInfo();
            secretInfo.setAppId(lines.get(0));
            secretInfo.setSecretKey(lines.get(1));
        }
        return secretInfo;
    }

    public SecretInfo getSecretInfo() {
        return secretInfo;
    }

    public void setSecretInfo(SecretInfo secretInfo) {
        this.secretInfo = secretInfo;
    }
}
