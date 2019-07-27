package book01.ch15;

import net.jcip.annotations.ThreadSafe;

/**
 * 2019年7月27日15:43:10
 * 程序清单 15-2 基于CAS实现的非阻塞计数器
 */
@ThreadSafe
public class CasCounter {
    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
