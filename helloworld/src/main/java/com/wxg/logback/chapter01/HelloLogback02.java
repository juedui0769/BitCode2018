package com.wxg.logback.chapter01;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2018年12月31日15:35:27
 *
 * from : https://logback.qos.ch/manual/introduction.html
 */
public class HelloLogback02 {

    /**
     *
     * {@link ch.qos.logback.core.ConsoleAppender}
     * : Appenders exist for many different destinations including the console, files, Syslog, TCP Sockets, JMS and many more.
     *
     * {@link LoggerContext}
     *
     * {@link ch.qos.logback.classic.Level}
     * {@link org.slf4j.Marker}
     *
     * {@link ch.qos.logback.classic.PatternLayout}
     *
     * {@link ch.qos.logback.classic.turbo.TurboFilter}
     *
     * {@link org.slf4j.event.LoggingEvent}
     * {@link ch.qos.logback.classic.spi.LoggingEvent}
     *
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("com.wxg.logback.chapter01.HelloLogback02");
        logger.debug("Hello world.");

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
