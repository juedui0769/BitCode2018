package com.wxg;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;

import javax.servlet.http.HttpServletRequest;

public class MyCommonTest {

    public void test01() {
        (
                (FlashMap)(
                        (ServletRequestAttributes)RequestContextHolder.getRequestAttributes()
                ).getRequest().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE)
        ).put("name", "张三丰");

        RequestAttributes reqAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) reqAttributes;
        HttpServletRequest request = requestAttributes.getRequest();
        Object attribute = request.getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE);
        FlashMap flashMap = (FlashMap) attribute;
        flashMap.put("name", "张三丰");
    }
}
