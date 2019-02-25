package com.wxg.okhttp;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.wxg.baidu.fanyi.BaiduFanyi;
import com.wxg.baidu.fanyi.info.BaiduTranslateFields;
import com.wxg.baidu.fanyi.info.SecretInfo;
import com.wxg.baidu.fanyi.util.FanyiLang;
import okhttp3.*;

import java.io.IOException;

/**
 * 2019年2月25日18:39:13
 * https://github.com/square/okhttp/blob/master/samples/guide/src/main/java/okhttp3/recipes/PostForm.java
 *      - 在以上链接，okhttp 有很多样例，可供参考
 */
public class PostToBaiduFanyi {

    private final OkHttpClient client = new OkHttpClient();

    private SecretInfo secretInfo;

    public PostToBaiduFanyi() {
        if(!BaiduFanyi.isInit()){
            String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
            BaiduFanyi.setSecretInfoStorePath(filepath);
        }
        BaiduFanyi baiduFanyi = BaiduFanyi.getInstance();
        secretInfo = baiduFanyi.getSecretInfo();
    }

    public void run() throws IOException {
        String query = "apple";
        String languageTo = FanyiLang.ZH;
        BaiduTranslateFields fields
                = new BaiduTranslateFields(query, languageTo, secretInfo);
        System.out.println(fields);
        FormBody formBody = new FormBody.Builder()
                .add("q", fields.getEncodeQuery())
                .add("from", fields.getFrom())
                .add("to", fields.getTo())
                .add("appid", fields.getAppid())
                .add("salt", fields.getSalt())
                .add("sign", fields.md5Sign())
                .build();
        Request request = new Request.Builder()
                .url("http://api.fanyi.baidu.com/api/trans/vip/translate")
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpectd code " + response);
            }

            System.out.println();
            String result = response.body().string();

            System.out.println(result);
        }

    }

    public void destroy() {
        client.dispatcher().executorService().shutdown();   //清除并关闭线程池
        client.connectionPool().evictAll();                 //清除并关闭连接池
    }

    public static void main(String[] args) throws IOException {
        PostToBaiduFanyi postToBaiduFanyi = new PostToBaiduFanyi();

        postToBaiduFanyi.run();
        postToBaiduFanyi.destroy();
    }

}
