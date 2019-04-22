package com.wxg.service;

@javax.jws.WebService
public class WebServiceImpl implements WebService {
    @Override
    public String sayHello(String name) {
        System.out.println("hahahaha成了啊");

        String aa = "hello, " + name + ", hahaha";
        return aa;
    }
}
