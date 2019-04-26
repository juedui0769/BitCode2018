package book01.ch02;

import net.jcip.annotations.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 程序清单 2-5 该Servlet在没有足够原子性保证的情况下对其最近计算结果进行缓存（不要这么做）
 * <hr>
 * <p>
 * 不变性条件之一是：在 lastFactors 中缓存的因数之积应该等于在 lastNumber 中缓存的数值。
 * </p>
 * <p>只有确保了这个不变性条件不被破坏，以下 Servlet 才是正确的。</p>
 * <p>当在不变性条件中涉及多个变量时，各个变量之间并不是彼此独立的，而是某个变量的值会对其他变量的值产生约束。</p>
 * <p>因此，当更新某一个变量时，需要在同一个原子操作中对其他变量同时进行更新。</p>
 */
@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {

    private final AtomicReference<BigInteger> lastNumber
            = new AtomicReference<>();

    private final AtomicReference<BigInteger[]> lastFactors
            = new AtomicReference<>();


    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(resp, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] bigIntegers) {

    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }





    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
