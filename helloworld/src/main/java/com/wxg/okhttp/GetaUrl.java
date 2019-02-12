package com.wxg.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * get a url
 */
public class GetaUrl {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
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
