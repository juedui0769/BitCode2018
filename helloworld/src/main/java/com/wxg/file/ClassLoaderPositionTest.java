package com.wxg.file;

import java.net.URL;

/**
 * 测试 `getClassLoader().getResource("")` 对应的位置
 */
public class ClassLoaderPositionTest {
    public static void main(String[] args) {
        URL root = ClassLoaderPositionTest.class.getClassLoader().getResource("");
        System.out.println(root.getPath());
    }
}
