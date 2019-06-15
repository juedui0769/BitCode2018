package com.wxg.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    private static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        logger.info("info");
        logger.error("error!");
        logger.debug("debug-");
    }
}
