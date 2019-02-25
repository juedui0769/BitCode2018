package com.wxg.okhttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Charsets;
import com.wxg.baidu.fanyi.BaiduFanyi;
import com.wxg.baidu.fanyi.info.BaiduTranslateFields;
import com.wxg.baidu.fanyi.info.BaiduTranslateResult;
import com.wxg.baidu.fanyi.info.SecretInfo;
import com.wxg.baidu.fanyi.util.FanyiLang;
import com.wxg.okhttp.util.ClientUtils;
import okhttp3.*;

import java.io.IOException;

/**
 * 2019年2月25日18:39:13
 * https://github.com/square/okhttp/blob/master/samples/guide/src/main/java/okhttp3/recipes/PostForm.java
 *      - 在以上链接，okhttp 有很多样例，可供参考
 */
public class PostToBaiduFanyi {

    private static final String baiduTranslatUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private OkHttpClient client = ClientUtils.getClient();

    private SecretInfo secretInfo;

    public PostToBaiduFanyi() {
        if(!BaiduFanyi.isInit()){
            String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
            BaiduFanyi.setSecretInfoStorePath(filepath);
        }
        BaiduFanyi baiduFanyi = BaiduFanyi.getInstance();
        secretInfo = baiduFanyi.getSecretInfo();
    }

    public BaiduTranslateResult invoke(String query, String languageTo) {
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

    public void run() {

        BaiduTranslateResult china = invoke("中国", FanyiLang.EN);
        System.out.println(china);

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        BaiduTranslateResult apple = invoke("apple", FanyiLang.ZH);
        System.out.println(apple);

//        String query = "apple";
//        String languageTo = FanyiLang.ZH;
//        BaiduTranslateFields fields
//                = new BaiduTranslateFields(query, languageTo, secretInfo);
//        System.out.println(fields);
//        FormBody formBody = new FormBody.Builder()
//                .add("q", fields.getEncodeQuery())
//                .add("from", fields.getFrom())
//                .add("to", fields.getTo())
//                .add("appid", fields.getAppid())
//                .add("salt", fields.getSalt())
//                .add("sign", fields.md5Sign())
//                .build();
//        Request request = new Request.Builder()
//                .url("http://api.fanyi.baidu.com/api/trans/vip/translate")
//                .post(formBody)
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new IOException("Unexpectd code " + response);
//            }
//
//            BaiduTranslateResult result
//                    = JSON.parseObject(response.body().string(), new TypeReference<BaiduTranslateResult>(){});
//
//            System.out.println(result);
//        }

    }

    public void destroy() {
        ClientUtils.destroy();
    }

    public static void main(String[] args) throws IOException {
        PostToBaiduFanyi postToBaiduFanyi = new PostToBaiduFanyi();

        postToBaiduFanyi.run();
        postToBaiduFanyi.destroy();
    }

}
