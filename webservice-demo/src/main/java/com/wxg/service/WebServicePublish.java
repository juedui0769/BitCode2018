package com.wxg.service;

import javax.xml.ws.Endpoint;

public class WebServicePublish {
    public static void main(String[] args) {
        // 定义WebService的发布地址，这个地址是提供给外界访问WebService的URL地址
        // URL地址格式为: http://ip:port/xxxx
        String address = "http://localhost:8989/ws/bb";

        Endpoint.publish(address, new WebServiceImpl());
        System.out.println("发布成功!");
        System.out.println("请访问 -> " + address + "?wsdl");
    }
}
