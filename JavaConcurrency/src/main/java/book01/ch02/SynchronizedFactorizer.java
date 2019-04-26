package book01.ch02;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * <p>程序清单2-6 这个Servlet能正确地缓存最新的计算结果，但并发性却非常糟糕（不要这么做）</p>
 * <hr>
 * <p>在程序清单2-6中使用了关键字 synchronized 来修饰 service 方法，
 * 因此在同一时刻只有一个线程可以执行 service 方法。</p>
 * <p>现在的 SynchronizedFactorizer 是线程安全的。</p>
 * <p>然而，这种方法却过于极端，因为多个客户端无法同时使用因数分解 Servlet，
 * 服务的响应性非常低，无法令人接受。</p>
 * <p>这是一个性能问题，而不是线程安全问题。</p>
 */
@ThreadSafe
public class SynchronizedFactorizer implements Servlet {

    @GuardedBy("this") private BigInteger lastNumber;

    @GuardedBy("this") private BigInteger[] lastFactors;

    @Override
    public synchronized void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber)) {
            encodeIntoResponse(resp, lastFactors);
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
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
