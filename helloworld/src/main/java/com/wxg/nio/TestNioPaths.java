package com.wxg.nio;

import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestNioPaths {


    @Test
    @Ignore
    public void test02() {
        Path path = Paths.get("src\\main\\java\\com\\wxg\\nio\\TestNioPaths.java");
        System.out.println(path);
    }

    @Test
    public void test01() {
        Path path = Paths.get(".");
        System.out.println(path.getFileName());
    }

}
