package com.wxg.exception;

import org.junit.Ignore;
import org.junit.Test;

/**
 * create at 2019年6月6日
 */
public class TestCustomerException {

    @Test
    @Ignore
    public void test01() throws CustomerException {
        throw new CustomerException("XX异常", ErrorCodeEnum.DP7001001);
    }

    @Test
    @Ignore
    public void test02() {
        throw new RuntimeException(new CustomerException("XX异常", ErrorCodeEnum.DP7001001));
    }

    @Test
    @Ignore
    public void test03() {
        CustomerException customerException = new CustomerException("XX异常", ErrorCodeEnum.DP7001001);
        throw new RuntimeException(customerException.getMessage());
    }
}
