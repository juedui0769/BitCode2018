package com.wxg.dom4j;

import com.google.common.io.Resources;
import com.wxg.file.FileTools;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

public class HelloWorld {

    /**
     * @link com.google.common.io.Files
     * https://dom4j.github.io/#parsing
     * https://dom4j.github.io/#xpath
     *
     */
    @Test
    public void test01() {
        URL url = Resources.getResource("");
        // /F:/wxg111_openapi/BitCode2018-beforeGetParent/helloworld/target/test-classes/
        File file = FileTools.beforeGetParent(url.getPath()).parent().parent().file();
        System.out.println(file);
        File pomFile = new File(file, "pom.xml");
        System.out.println(pomFile);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(pomFile);
            Element root = document.getRootElement();
            System.out.println(root);
            System.out.println(document.selectSingleNode("//properties"));
            Node node = document.selectSingleNode("//parent/version");
            System.out.println(node);
            List<Node> nodes = root.selectNodes("//version");
            if (null != nodes) {
                for (Node n : nodes) {
                    System.out.println(n);
                }
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + pomFile);
        }
    }
}
