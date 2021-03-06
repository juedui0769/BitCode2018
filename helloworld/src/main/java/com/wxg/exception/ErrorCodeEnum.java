package com.wxg.exception;

public enum ErrorCodeEnum {
    DP7001001("DP7001001", "调D+存款系统客户查询接口返回值异常"),
    DP7001002("DP7001002", "调D+存款系统客户查询接口异常")
    ;

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
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
