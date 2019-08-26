package com.wxg.study.util;

import java.net.URL;

public class JavaNIOUtils {

    public static String getResourcePath(String resourceName) {
        URL url = JavaNIOUtils.class.getClassLoader().getResource(resourceName);
        return url.getPath();
    }
}
