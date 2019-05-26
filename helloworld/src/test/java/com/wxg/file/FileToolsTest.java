package com.wxg.file;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileToolsTest {

    @Test(expected = RuntimeException.class)
    public void test01() {
        String filepath = "";
        System.out.println(FileTools.beforeGetParent(filepath).parent().file());
    }

    @Test(expected = RuntimeException.class)
    public void test02() {
        String filepath = "D:\\xxA";
        System.out.println(FileTools.beforeGetParent(filepath).parent().file());
    }

    @Test(expected = RuntimeException.class)
    public void test03() {
        String filepath = "D:\\xxA\\ss";
        System.out.println(FileTools.beforeGetParent(filepath).parent().file());
    }

    @Test(expected = RuntimeException.class)
    public void test04() {
        String filepath = "D:\\";
        System.out.println(FileTools.beforeGetParent(filepath).parent().file());
    }
}