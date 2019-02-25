package com.wxg.baidu.fanyi.info;

import com.wxg.baidu.fanyi.BaiduFanyi;
import com.wxg.baidu.fanyi.util.FanyiLang;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaiduTranslateFieldsTest {

    private SecretInfo secretInfo;

    public BaiduTranslateFieldsTest() {
        String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
        BaiduFanyi.setSecretInfoStorePath(filepath);
        secretInfo = BaiduFanyi.getInstance().getSecretInfo();
    }

    /**
     * 2019年2月25日17:40:18
     * 结果与网页上的结果一致： https://md5jiami.51240.com/
     */
    @Test
    public void md5Sign() {
        {
            String query = "apple";
            String languageTo = FanyiLang.ZH;
            BaiduTranslateFields baiduTranslateFields
                    = new BaiduTranslateFields(query, languageTo, secretInfo);
            System.out.println(baiduTranslateFields.getSalt());
            System.out.println(baiduTranslateFields.getSign());
            System.out.println(baiduTranslateFields.md5Sign());
            System.out.println();
        }
        {
            String query = "中国";
            String languageTo = FanyiLang.EN;
            BaiduTranslateFields baiduTranslateFields
                    = new BaiduTranslateFields(query, languageTo, secretInfo);
            System.out.println(baiduTranslateFields.getSalt());
            System.out.println(baiduTranslateFields.getSign());
            System.out.println(baiduTranslateFields.md5Sign());
            System.out.println();
        }
    }
}