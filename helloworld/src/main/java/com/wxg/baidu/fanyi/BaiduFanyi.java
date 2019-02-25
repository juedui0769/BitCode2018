package com.wxg.baidu.fanyi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.wxg.baidu.fanyi.exception.BaiduFanyiException;
import com.wxg.baidu.fanyi.info.BaiduTranslateFields;
import com.wxg.baidu.fanyi.info.BaiduTranslateResult;
import com.wxg.baidu.fanyi.info.SecretInfo;
import com.wxg.baidu.fanyi.official.TransApi;
import com.wxg.okhttp.util.ClientUtils;
import com.wxg.socket.old.Client;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaiduFanyi {

    private static final String baiduTranslatUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private static volatile BaiduFanyi instance;

    // 百度翻译API，申请信息
    private SecretInfo secretInfo;

    private static String localFilePath;

    private BaiduFanyi() {}

    public synchronized static BaiduFanyi getInstance() {
        if (instance == null) {
            if (localFilePath == null) {
                throw new BaiduFanyiException("请先设置'申请信息'在本地的存储位置, `setSecretInfoStorePath(...)`");
            }
            instance = new BaiduFanyi();
            SecretInfo secretInfo = instance.getIdAndSecretkeyFromLocalFile(localFilePath);
            instance.setSecretInfo(secretInfo);
        }
        return instance;
    }

    /**
     * 2019年2月25日10:32:12
     * 目前只提供从本地获取"申请信息"的方法
     * 未来可提供从 URL 获取"申请信息"的方法
     * @param secretInfoStorePath "申请信息"在本地的存放位置
     */
    public static void setSecretInfoStorePath(String secretInfoStorePath) {
        localFilePath = secretInfoStorePath;
    }

    /**
     * `volatile` : 是否添加了`volatile`, 本方法就是线程安全的？
     * @return
     */
    public static boolean isInit() {
        return instance == null ? false : true;
    }

    /**
     * 从官网下载的demo： 此方法调用的是官方的样例
     * @param query
     * @param languageTo
     * @return
     */
    public String invokeOfficial(String query, String languageTo) {
        TransApi transApi = new TransApi(secretInfo.getAppId(), secretInfo.getSecretKey());
        return transApi.getTransResult(query, "auto", languageTo);
    }

    /**
     * 通过 okhttp 调用“百度翻译API”
     * {@link ClientUtils#destroy()} 需要注意一下： 清理client！
     *
     * @param query
     * @param languageTo
     * @return
     */
    public BaiduTranslateResult invokeByOkhttp(String query, String languageTo) {
        BaiduTranslateFields fields
                = new BaiduTranslateFields(query, languageTo, secretInfo);
        FormBody formBody = new FormBody.Builder()
//                .add("q", fields.getEncodeQuery())
                .add("q", fields.getQ())
                .add("from", fields.getFrom())
                .add("to", fields.getTo())
                .add("appid", fields.getAppid())
                .add("salt", fields.getSalt())
                .add("sign", fields.md5Sign())
                .build();
        Request request = new Request.Builder()
                .url(baiduTranslatUrl)
                .post(formBody)
                .build();

        OkHttpClient client = ClientUtils.getClient();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpectd code " + response);
            }

            BaiduTranslateResult result
                    = JSON.parseObject(response.body().string(), new TypeReference<BaiduTranslateResult>(){});

//            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 2019年2月25日10:10:49
     * 获取申请信息（APPID和密钥）
     * @param filepath
     * @return
     */
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
