package com.wxg;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContext;

public class MyRequestContext extends RequestContext {

    public void test01() {
        ((FlashMap)getRequest().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE)).put("name", "张三丰");
    }

}
