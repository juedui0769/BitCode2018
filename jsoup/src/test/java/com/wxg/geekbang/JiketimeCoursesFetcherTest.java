package com.wxg.geekbang;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JiketimeCoursesFetcherTest {

    final Logger logger = LoggerFactory.getLogger(JiketimeCoursesFetcherTest.class);

    final static String FILENAME = "D:\\02_webhtml\\极客时间-提升技术认知.html";
    final static String UTF_8 = "UTF-8";


    @Test
    public void test04() throws IOException {
        Document doc = Jsoup.parse(new File(FILENAME), UTF_8);

        if (null != doc) {
            Elements elements = doc.select("div[class='_3M3E-ESU_0']");
            if (null != elements) {
                for (Element ele : elements) {
                    Element courseTitle = ele.selectFirst("div[class='_3G50nw0p_0'] h2");
                    Element forkNums = ele.selectFirst("div[class='_3G50nw0p_0'] p");
                    Element author = ele.selectFirst("div[class='_33lENDr7_0']");
                    Element price = ele.selectFirst("p[class='_14cxbu2p_0']");

                    System.out.printf("%s, %s, %s, %s\r\n",
                            courseTitle.text(), author.text(), forkNums.text(), price.text());
                }
            }
        }
    }

    @Test
    public void test03() throws IOException {
        Document doc = Jsoup.parse(new File(FILENAME), UTF_8);

        if (null != doc) {
            Elements elements = doc.select("div[class='_3M3E-ESU_0']");
            if (null != elements) {
                for (Element ele : elements) {
                    Element courseTitle = ele.selectFirst("div[class='_3G50nw0p_0'] h2");
                    Element forkNums = ele.selectFirst("div[class='_3G50nw0p_0'] p");
                    Element author = ele.selectFirst("div[class='_33lENDr7_0']");
                    Element price = ele.selectFirst("p[class='_14cxbu2p_0']");

                    logger.info("courseTitle : {}, author : {}, forkNums: {}, price: {}",
                            courseTitle.text(), author.text(), forkNums.text(), price.text());
                }
            }
        }
    }



    /**
     * 使用 guava API 读取文件内容, 但是 jsoup 不需要，可以直接提供文件路径给 jsoup
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        List<String> lines = Files.readLines(new File(FILENAME), Charsets.UTF_8);
        if (null != lines) {
            for (String line : lines) {
                logger.info(line);
            }
        }
    }


    /**
     * 使用的是 src/main/resources/logback.xml 文件中的配置
     */
    @Test
    public void test01() {
        logger.info("hello");
    }
}