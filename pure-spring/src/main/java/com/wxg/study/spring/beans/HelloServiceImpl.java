package com.wxg.study.spring.beans;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

/**
 * {@link Service}
 * {@link Component}
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
