package com.wxg.logback.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2018年12月31日15:04:40
 * from : https://logback.qos.ch/manual/introduction.html
 */
public class HelloLogback01 {

    /**
     *
     * {@link ch.qos.logback.core.status.StatusManager}
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("com.wxg.logback.chapter01.HelloLogback01");
        logger.debug("Hello world.");
    }
}
