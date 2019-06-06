package com.wxg.exception;

public enum ResponseUtil {

    // failed, failure
    FAILURE("网络异常", "601")
    ;

    private String code;
    private String msg;

    ResponseUtil(String msg, String code) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
