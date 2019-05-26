package com.wxg.xpath;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class XpathToolsTest {

    public static final String PREFIX = "my:";

    @Test
    public void wrap() {
        String regex = "/{1,2}([^/]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("");
        String[] arr = {"//parent/version", "/aa/bb", "/parent"};
        for (String originStr : arr) {
            matcher.reset(originStr);
            while (matcher.find()) {
//                System.out.println(matcher.group(1));
                originStr = originStr.replace(matcher.group(1), PREFIX + matcher.group(1));
            }
            System.out.println(originStr);
        }
    }
}