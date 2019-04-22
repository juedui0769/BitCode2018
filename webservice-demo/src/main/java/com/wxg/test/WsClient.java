package com.wxg.test;

import com.wxg.client.WebServiceImpl;
import com.wxg.client.WebServiceImplService;

public class WsClient {
    public static void main(String[] args) {
        WebServiceImplService factory = new WebServiceImplService();
        WebServiceImpl wsImpl = factory.getWebServiceImplPort();
        String resResult = wsImpl.sayHello("项少龙");
        System.out.println(resResult);
        System.out.println(wsImpl.sayHello("岳不群"));
    }
}
