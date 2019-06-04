package com.wxg.exception;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 为了测试异常, 需要时将 {@link Ignore} 移除
 */
public class Main {

    @Test
    @Ignore
    public void test01() throws CustomerException {
        throw new CustomerException(ErrorCodeEnum.DP7001001);
    }

    @Test
    @Ignore
    public void test02() {
        throw new RuntimeException(new CustomerException(ErrorCodeEnum.DP7001001));
    }

    @Test
    @Ignore
    public void test03() {
        CustomerException customerException = new CustomerException(ErrorCodeEnum.DP7001001);
        throw new RuntimeException(customerException.getMessage());
    }
}
