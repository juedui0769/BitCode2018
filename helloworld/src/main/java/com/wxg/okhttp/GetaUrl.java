package com.wxg.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * get a url
 */
public class GetaUrl {

    static OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * 解决 “远程主机强迫关闭一个现有连接”
     *
     * @throws IOException
     */
    @AfterClass
    public static void destroy() throws IOException {
        System.out.println(client);

        client.dispatcher().executorService().shutdown();   //清除并关闭线程池
        client.connectionPool().evictAll();                 //清除并关闭连接池

        client = null;
    }

    @Test
    public void testLocalServer() throws IOException {
        /**
         * server是采用 `moco` 搭建
         * 搭建方式参考： https://github.com/juedui0769/StudyNotes2018/blob/master/129_Server_Moco.md
         */
        String local_url = "http://localhost:8088/hello";
        String body = run(local_url);
        System.out.println(body);
    }

    @Test(expected = UnknownHostException.class)
    public void testException() throws IOException {
        String body = run("https://www.oschina.com");
        System.out.println(body);
    }

    @Test
    public void testOsc() throws IOException {
        String body = run("https://www.oschina.net");
        System.out.println(body);
    }

    @Test
    public void testBaidu() throws IOException {
        String body = run("https://www.baidu.com");
        System.out.println(body);
    }


    public static void main(String[] args) {


    }
}
