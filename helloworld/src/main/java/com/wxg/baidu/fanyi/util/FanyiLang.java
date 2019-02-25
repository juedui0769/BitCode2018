package com.wxg.baidu.fanyi.util;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 2019年2月25日11:04:08
 * 使用`main`方法生成的常量类。
 * "D:\\wxg_test\\baidu\\lang.txt"
 *      是从 http://api.fanyi.baidu.com/api/trans/product/apidoc 获取的
 */
public final class FanyiLang {

    public static final String AUTO = "auto";

    public static final String ZH = "zh"; // 中文

    public static final String EN = "en"; // 英语

    public static final String YUE = "yue"; // 粤语

    public static final String WYW = "wyw"; // 文言文

    public static final String JP = "jp"; // 日语

    public static final String KOR = "kor"; // 韩语

    public static final String FRA = "fra"; // 法语

    public static final String SPA = "spa"; // 西班牙语

    public static final String TH = "th"; // 泰语

    public static final String ARA = "ara"; // 阿拉伯语

    public static final String RU = "ru"; // 俄语

    public static final String PT = "pt"; // 葡萄牙语

    public static final String DE = "de"; // 德语

    public static final String IT = "it"; // 意大利语

    public static final String EL = "el"; // 希腊语

    public static final String NL = "nl"; // 荷兰语

    public static final String PL = "pl"; // 波兰语

    public static final String BUL = "bul"; // 保加利亚语

    public static final String EST = "est"; // 爱沙尼亚语

    public static final String DAN = "dan"; // 丹麦语

    public static final String FIN = "fin"; // 芬兰语

    public static final String CS = "cs"; // 捷克语

    public static final String ROM = "rom"; // 罗马尼亚语

    public static final String SLO = "slo"; // 斯洛文尼亚语

    public static final String SWE = "swe"; // 瑞典语

    public static final String HU = "hu"; // 匈牙利语

    public static final String CHT = "cht"; // 繁体中文

    public static final String VIE = "vie"; // 越南语

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("D:\\wxg_test\\baidu\\lang.txt"), Charsets.UTF_8);
        String tpl = "public static final String {0} = \"{1}\"; // {2}";
        for (String line : lines) {
            String[] split = line.split("\\s");
            String s = tpl.replace("{0}", split[0].toUpperCase())
                    .replace("{1}", split[0])
                    .replace("{2}", split[1]);
            System.out.println(s);
            System.out.println();
        }
    }
}
