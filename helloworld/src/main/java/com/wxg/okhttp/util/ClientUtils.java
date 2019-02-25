package com.wxg.okhttp.util;

import okhttp3.OkHttpClient;

public class ClientUtils {

    private static volatile OkHttpClient client;

    public synchronized static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }

        return client;
    }

    public static void destroy() {
        if (client != null) {
            client.dispatcher().executorService().shutdown();   //清除并关闭线程池
            client.connectionPool().evictAll();                 //清除并关闭连接池

            client = null;
        }
    }
}
