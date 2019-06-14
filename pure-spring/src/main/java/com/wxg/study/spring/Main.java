package com.wxg.study.spring;

import com.wxg.study.spring.beans.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("pure-spring.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);

        String hello = helloService.sayHello("");

        System.out.println(hello);

    }
}
