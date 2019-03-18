package com.wxg.netty;

import com.jfinal.core.JFinal;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;

/**
 * {@link EventLoopGroup}
 * {@link MultithreadEventExecutorGroup}
 * {@link java.util.Date}
 * {@link io.netty.bootstrap.Bootstrap}
 * {@link com.google.common.collect.Maps}
 * {@link com.jfinal.core.JFinal}
 * {@link io.netty.util.concurrent.ThreadPerTaskExecutor}
 */
public class FirstLink {
    public static void main(String[] args) {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        JFinal me = JFinal.me();
    }
}
