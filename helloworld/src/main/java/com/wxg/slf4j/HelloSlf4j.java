package com.wxg.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2018年12月31日13:15:26
 * from : https://www.slf4j.org/manual.html
 */
public class HelloSlf4j {
    /**
     *
     * output :
     SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
     SLF4J: Defaulting to no-operation (NOP) logger implementation
     SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
     *
     * {@link org.slf4j.impl.StaticLoggerBinder}
     *
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloSlf4j.class);
        logger.info("Hello World");
    }
}
