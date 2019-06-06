package com.wxg.exception;

/**
 * update at 2019年6月6日
 */
public class Main {

    public static void main(String[] args) throws Exception {
        foo01();
    }

    private static void foo01() throws CustomerException {
        throw new CustomerException(ResponseUtil.FAILURE, ErrorCodeEnum.DP7001001);
    }



}
