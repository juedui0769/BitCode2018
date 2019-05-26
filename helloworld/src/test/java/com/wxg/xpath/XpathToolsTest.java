package com.wxg.xpath;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class XpathToolsTest {

    public static final String PREFIX = "my:";

    @Test
    public void wrap() {
        String regex = "/{1,2}([^/@]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("");
        String[] arr = {"//parent/version", "/aa/bb", "/parent", "//@lang",
                    "bookstore"};
        for (String originStr : arr) {
            matcher.reset(originStr);
            while (matcher.find()) {
//                System.out.println(matcher.group(1));
                originStr = originStr.replace(matcher.group(1), PREFIX + matcher.group(1));
            }
            System.out.println(originStr);
        }
    }

    /**
     * 测试数据来自 : http://www.w3school.com.cn/xpath/xpath_syntax.asp
     * 这里`replace`会有问题: 比如 `/bookstore/book` 中 `bookstore`包含`book`
     */
    @Test
    public void test01() {
        String regex = "/{1,2}([^/@*]+)|^([^/@()*]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("");
        String[] arr = {"bookstore", "/bookstore", "bookstore/book", "//book",
                "bookstore//book", "//@lang",
                "/bookstore/book[1]", "/bookstore/book[last()]", "/bookstore/book[last()-1]",
                "/bookstore/book[position()<3]", "//title[@lang]", "//title[@lang='eng']",
                "/bookstore/book[price>35.00]", "/bookstore/book[price>35.00]/title",
                "*", "@*", "node()",
                "/bookstore/*", "//*", "//title[@*]",
                "//book/title | //book/price", "//title | //price", "/bookstore/book/title | //price"};
        String groupStr = null;
        for (String originStr : arr) {
            matcher.reset(originStr);
            while (matcher.find()) {
                groupStr = matcher.group(1) == null ? matcher.group(2) : matcher.group(1);
//                System.out.println(matcher.group(1));
                // 这里`replace`会有问题: 比如 `/bookstore/book` 中 `bookstore`包含`book`
                matcher.replaceFirst("");
                originStr = originStr.replace(groupStr, PREFIX + groupStr);
            }
            System.out.println(originStr);
        }
    }

    /**
     * 貌似无解啊！
     */
    @Test
    public void test02() {
        String regex = "/{1,2}([^/@*]+)|^([^/@()*]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("");
        String[] arr = {"bookstore", "/bookstore", "bookstore/book", "//book",
                "bookstore//book", "//@lang",
                "/bookstore/book[1]", "/bookstore/book[last()]", "/bookstore/book[last()-1]",
                "/bookstore/book[position()<3]", "//title[@lang]", "//title[@lang='eng']",
                "/bookstore/book[price>35.00]", "/bookstore/book[price>35.00]/title",
                "*", "@*", "node()",
                "/bookstore/*", "//*", "//title[@*]",
                "//book/title | //book/price", "//title | //price", "/bookstore/book/title | //price"};
        String groupStr = null;
        final int arrSize = 20;
        String[] fixedArr = new String[arrSize];
        for (String originStr : arr) {
            matcher.reset(originStr);
            int countI = 0;
            for (int i = 0; matcher.find() && i < arrSize; i++, countI++) {
                groupStr = matcher.group(1) == null ? matcher.group(2) : matcher.group(1);
                fixedArr[countI] = groupStr;
                originStr = originStr.replaceFirst(groupStr, String.format("{%d}", i));
            }
            System.out.println("originStr : " + originStr);
            System.out.println("fixedArr : " + Arrays.toString(fixedArr));
//            while (matcher.find()) {
//                groupStr = matcher.group(1) == null ? matcher.group(2) : matcher.group(1);
////                System.out.println(matcher.group(1));
//                // 这里`replace`会有问题: 比如 `/bookstore/book` 中 `bookstore`包含`book`
//                matcher.replaceFirst("");
//                originStr = originStr.replace(groupStr, PREFIX + groupStr);
//            }
        }
    }


    @Test
    public void test03() {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("{%d}", i));
        }
    }
}