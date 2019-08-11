package com.wxg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyFetchFrom51jobTest {
    final Logger logger = LoggerFactory.getLogger(CompanyFetchFrom51jobTest.class);
    final static String UTF_8 = "UTF-8";
    final static String GB2312 = "GB2312";

    @Test
    public void test01() throws IOException {
        List<File> fileList = new ArrayList<>();
        fileList.add(new File("C:\\Users\\Wxg\\Desktop\\22", "我的申请丨前程无忧（51Job）01.html"));
        fileList.add(new File("C:\\Users\\Wxg\\Desktop\\22", "我的申请丨前程无忧（51Job）02.html"));
        fileList.add(new File("C:\\Users\\Wxg\\Desktop\\22", "我的申请丨前程无忧（51Job）03.html"));
        fileList.add(new File("C:\\Users\\Wxg\\Desktop\\22", "我的申请丨前程无忧（51Job）04.html"));
//        File file = new File("C:\\Users\\Wxg\\Desktop\\22", "我的申请丨前程无忧（51Job）01.html");
        for (File file : fileList) {
            Document doc = Jsoup.parse(file, GB2312);
            if (null != doc) {
                Element apox = doc.selectFirst("div[class='apox']");
                if (null != apox) {
                    Elements eles = apox.select("div[class='e']");
                    if (null != eles) {
                        for (Element ele : eles) {
                            Element company = ele.selectFirst("a[class='gs']");
                            System.out.println(company.text());
                        }
                    }
                }
            }
        }

    }
}
