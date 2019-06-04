package com.wxg.exception;

public class CustomerException extends Exception {

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

    public CustomerException(ErrorCodeEnum errorCodeEnum) {
        super("[" + errorCodeEnum.getCode() + "]" + errorCodeEnum.getMsg());
        this.errorCodeEnum = errorCodeEnum;
    }
}
