package com.wxg.okhttp;

import com.wxg.okhttp.util.GetUtils;

/**
 * 2019年2月22日21:34:52
 *
 * 验证： 在多次调用中，server（ http://localhost:8088/hello）的情况
 * 现象： 调用 5 次， 间隔 1 秒，如果不调用 `g.destroy()`，
 *      最后一次调用完成后，server端会出现“远程主机强迫关闭一个现有连接”
 *      如果调用 `g.destroy()`，则 server 端不会出现异常
 * 结论： okhttp 的 get 请求，再转向调用下一个请求时会自动释放（断开连接的信号）
 *      如果只请求一次，需要主动释放
 */
public class MultiGetTest {

    public static void main(String[] args) throws InterruptedException {
        GetUtils g = new GetUtils();

        for (int i=0;i<5;i++){
            String local_url = "http://localhost:8088/hello";
            String body = g.run(local_url);
            System.out.println(body);
            System.out.println("  --  ");

            Thread.sleep(1030);
        }

        g.destroy();

    }
}
