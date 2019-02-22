package com.wxg.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2019年2月22日21:05:28
 */
public class GetInThread {

    OkHttpClient client = new OkHttpClient();

    private String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String getLocalServer(String url) {

        String body = null;

        try {
            body = run(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    public void destroy() {
        client.dispatcher().executorService().shutdown();   //清除并关闭线程池
        client.connectionPool().evictAll();                 //清除并关闭连接池
    }

    public static void main(String[] args) {

        GetInThread getInThread = new GetInThread();

        // === begin{线程关闭钩子} ===
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(">>> shutdown ");
                getInThread.destroy();
            }
        };
        Runtime.getRuntime().addShutdownHook(t);
        // === end  {线程关闭钩子} ===

        ExecutorService singleThread = Executors.newSingleThreadExecutor();

        // === begin{核心业务代码} ===
        singleThread.execute(new Runnable() {
            @Override
            public void run() {


                /**
                 * server是采用 `moco` 搭建
                 * 搭建方式参考： https://github.com/juedui0769/StudyNotes2018/blob/master/129_Server_Moco.md
                 */
                String local_url = "http://localhost:8088/hello";
                String str = getInThread.getLocalServer(local_url);

                System.out.println(str);
            }
        });
        // === end  {核心业务代码} ===

        // ExecutorService 关闭
        singleThread.shutdown();


    }
}
