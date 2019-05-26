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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test02() {
        URL url = Resources.getResource("student.xml");
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(url);
            System.out.println(doc.selectSingleNode("//name"));
            List<Node> nodes = doc.selectNodes("//name");
            if (nodes != null) {
                for (Node n : nodes) {
                    System.out.println(n.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + url.getPath());
        }
    }

    /**
     * https://blog.csdn.net/story_xia/article/details/89527726
     */
    @Test
    public void test03() {
        URL url = Resources.getResource("helloworld_pom.xml");
        SAXReader reader = new SAXReader();
        Map<String, String> map = new HashMap<>();
        map.put("my", "http://maven.apache.org/POM/4.0.0");
        reader.getDocumentFactory().setXPathNamespaceURIs(map);
        try {
            Document doc = reader.read(url);
            System.out.println(doc.selectSingleNode("//my:version"));
            List<Node> nodes = doc.selectNodes("//my:version");
            if (nodes != null) {
                for (Node n : nodes) {
                    System.out.println(n.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + url.getPath());
        }
    }

    @Test
    public void test04() {
        URL url = Resources.getResource("helloworld_pom.xml");
        SAXReader reader = new SAXReader();
        Map<String, String> map = new HashMap<>();
        map.put("my", "http://maven.apache.org/POM/4.0.0");
        reader.getDocumentFactory().setXPathNamespaceURIs(map);
        try {
            Document doc = reader.read(url);
            System.out.println(doc.selectSingleNode("//my:version"));
            List<Node> nodes = doc.selectNodes("//my:version");
            if (nodes != null) {
                for (Node n : nodes) {
                    System.out.println(n.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + url.getPath());
        }
    }

    /**
     * attr 不受 namespace 影响
     */
    @Test
    public void test05() {
        URL url = Resources.getResource("helloworld_pom.xml");
        SAXReader reader = new SAXReader();
//        Map<String, String> map = new HashMap<>();
//        map.put("my", "http://maven.apache.org/POM/4.0.0");
//        reader.getDocumentFactory().setXPathNamespaceURIs(map);
        try {
            Document doc = reader.read(url);
            Node nodeAttr = doc.selectSingleNode("//@id");
            if (null != nodeAttr) {
                System.out.println("nodeAttr : " + nodeAttr.getText());
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + url.getPath());
        }
    }

    /**
     * 只能拿到某个元素的所有属性
     * `doc`应该是root元素的父亲吧？ 它没有属性
     * 如果拿到 `<dependency id="junit">` 那么可以获得它的属性
     */
    @Test
    public void test06() {
        URL url = Resources.getResource("helloworld_pom.xml");
        SAXReader reader = new SAXReader();
//        Map<String, String> map = new HashMap<>();
//        map.put("my", "http://maven.apache.org/POM/4.0.0");
//        reader.getDocumentFactory().setXPathNamespaceURIs(map);
        try {
            Document doc = reader.read(url);
            List<Node> nodeList = doc.selectNodes("@*");
            if (null != nodeList) {
                System.out.println(nodeList.size());
                System.out.println("--------------");
                for (Node n : nodeList) {
                    System.out.println(n.getName() + " : " + n.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + url.getPath());
        }
    }

    /**
     * 输出结果有很多空白元素
     * 只能拿到某个元素的`子`元素，不能拿到`孙`元素
     */
    @Test
    public void test07() {
        URL url = Resources.getResource("helloworld_pom.xml");
        SAXReader reader = new SAXReader();
        Map<String, String> map = new HashMap<>();
        map.put("my", "http://maven.apache.org/POM/4.0.0");
        reader.getDocumentFactory().setXPathNamespaceURIs(map);
        try {
            Document doc = reader.read(url);
            List<Node> nodeList = doc.selectNodes("//my:project/*");
            if (null != nodeList) {
                System.out.println(nodeList.size());
                System.out.println("--------------");
                for (Node n : nodeList) {
                    System.out.println(n.getName() + " : " + n.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println("dom4j读取xml出错, file=" + url.getPath());
        }
    }


}
