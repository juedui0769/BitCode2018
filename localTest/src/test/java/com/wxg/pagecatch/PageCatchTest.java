package com.wxg.pagecatch;

import com.wxg.daily.pagecatch.PageCatcher;
import org.junit.AfterClass;
import org.junit.Test;

public class PageCatchTest {

    String storeDir = "D:\\wxg_test\\01";

    @AfterClass
    public static void tearDown() {
        new PageCatcher().destroy();
    }

    @Test
    public void test_getAndSave() {
        PageCatcher pageCatcher = new PageCatcher();
        String url = "http://www.oschina.net";
        String json = pageCatcher.getAndSave(storeDir, url);
        System.out.println(json);
    }

    @Test
    public void test01() {

    }
}
