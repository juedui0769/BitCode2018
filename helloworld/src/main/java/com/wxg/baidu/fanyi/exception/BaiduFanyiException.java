package com.wxg.baidu.fanyi.exception;

public class BaiduFanyiException extends RuntimeException {
    public BaiduFanyiException() {
        super();
    }

    public BaiduFanyiException(String message) {
        super(message);
    }

    public BaiduFanyiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaiduFanyiException(Throwable cause) {
        super(cause);
    }

    protected BaiduFanyiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
