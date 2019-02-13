package com.wxg.okhttp;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;

/**
 * Post To A Server
 */
public class PostToAServer {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        }
        Response response = client.newCall(request).execute();
        String returnStr = response.body().string();

        if (response.isSuccessful()) {
            response.close();
        }


        return returnStr;
    }


    /***
     * 解决 “远程主机强迫关闭一个现有连接”
     *
     *
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {
//        EventListener.Factory factory = client.eventListenerFactory();
//        factory.create()
        System.out.println(client);

//        client.cache().close();                             //清除cache
        client.dispatcher().executorService().shutdown();   //清除并关闭线程池
        client.connectionPool().evictAll();                 //清除并关闭连接池
    }

    @Test
    public void testLocalPostMocoServer() throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("foo", "bar");
        String json = com.alibaba.fastjson.JSON.toJSONString(map);

        // 使用 `moco` 搭建的本地 post 请求
        // 参考 : https://github.com/juedui0769/StudyNotes2018/blob/master/129_Server_Moco.md
        String url = "http://localhost:8089/json";
        String result = post(url, json);

//        client = null;

//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(result);
    }

    @Test
    public void testWeather() {

    }

}
