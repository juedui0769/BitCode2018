package com.wxg.exception;

public class CustomerException extends Exception {

    private String code;
    private ErrorCodeEnum errorCodeEnum;

    public CustomerException() {
        super();
    }

    public CustomerException(String msg) {
        super(msg);
    }

    public CustomerException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CustomerException(Throwable cause) {
        super(cause);
    }

    public CustomerException(String msg, ErrorCodeEnum errorCodeEnum) {
        super(msg + "[" + errorCodeEnum.getCode() + "]");
        this.errorCodeEnum = errorCodeEnum;
    }

    public CustomerException(ResponseUtil responseUtil, ErrorCodeEnum errorCodeEnum) {
        super(responseUtil.getMsg() + "[" + errorCodeEnum.getCode() + "]");
        this.errorCodeEnum = errorCodeEnum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }
}
