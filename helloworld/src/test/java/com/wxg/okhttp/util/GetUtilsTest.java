package com.wxg.okhttp.util;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * 2019年2月22日21:49:34
 */
public class GetUtilsTest {

    static GetUtils g = new GetUtils();

    @AfterClass
    public static void destroy() {
        g.destroy();
    }

    /**
     * http://localhost:8088/hello （本地搭建，请替换 url或者 @Ignore）
     *
     * @throws InterruptedException
     */
    @Test
    public void test01() throws InterruptedException {
        for (int i=0;i<5;i++){
            String local_url = "http://localhost:8088/hello";
            String body = g.run(local_url);
            System.out.println(body);
            System.out.println("  --  ");

            Thread.sleep(1030);
        }
    }

}