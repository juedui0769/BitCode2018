package com.wxg.baidu.fanyi.official;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 2019年2月25日17:26:20
 */
public class MD5Test {

    /**
     * If you must interoperate with a system that requires MD5,
     * then use this method, despite its deprecation.
     * But if you can choose your hash function, avoid MD5, which is neither fast nor secure.
     * As of January 2017, we suggest:
     *
     * 如果您必须与需要MD5的系统进行交互操作，那么尽管该方法被弃用，还是要使用它。
     * 但是，如果您可以选择散列函数，请避免使用既不快速也不安全的MD5。
     * 截至2017年1月，我们建议：
     *
     * 以上摘自 {@link Hashing#md5()} 的javadoc
     */
    @Test
    public void test01() {
        List<String> list = Arrays.asList("apple", "中国", "中国人66", "中国Greate!");
        for (String str : list) {
            String s = MD5.md5(str);
            String s1 = Hashing.md5().hashString(str, Charsets.UTF_8).toString();
            System.out.println(s);
            System.out.println(s1);
            System.out.println();
            assertEquals(s, s1);
        }
    }

}