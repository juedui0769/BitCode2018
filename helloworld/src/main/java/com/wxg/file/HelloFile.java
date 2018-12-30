package com.wxg.file;

import java.io.File;

public class HelloFile {
    /**
     * 感觉 `user.dir` 非常不保险！
     * 如果只加载 "helloworld" ，那么 `user.dir` 的值就不同了。
     * 而且，打包成jar文件后，`user.dir`的值也不同了。
     *
     * @param args
     */
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir"), "helloworld");
        System.out.println(file.getAbsolutePath());
    }
}
