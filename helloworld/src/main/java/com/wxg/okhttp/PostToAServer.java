package com.wxg.okhttp;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

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
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Test
    public void testWeather() {

    }

}
