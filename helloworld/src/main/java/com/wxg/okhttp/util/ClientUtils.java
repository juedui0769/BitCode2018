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

    /**
     * 2019年2月26日10:04:17 update : 添加 `synchronized` 关键字
     * 但是, `client`有关键字`volatile`修饰, 如果不加 `synchronized` 也不会被重排序吧？
     */
    public synchronized static void destroy() {
        if (client != null) {
            client.dispatcher().executorService().shutdown();   //清除并关闭线程池
            client.connectionPool().evictAll();                 //清除并关闭连接池

            client = null;
        }
    }
}
