package com.wxg.jdk.proxy;

import java.lang.reflect.*;

/**
 * 2019年1月2日10:13:11
 * from : https://www.cnblogs.com/MOBIN/p/5597215.html
 */
public class MyProxy {
    public interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello world!");
        }
    }

    static class HWInvocationHandler implements InvocationHandler {
        private Object target;
        public HWInvocationHandler(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---插入前置通知代码---");
            Object result = method.invoke(target, args);
            System.out.println("---插入后置通知代码---");
            return result;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        useMode01();
        useMode02();
    }

    /**
     * 方式二
     *
     */
    private static void useMode02() {
        IHello iHello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),
                new Class[]{IHello.class},
                new HWInvocationHandler(new Hello()));
        iHello.sayHello();
    }

    /**
     * 方式一
     *
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void useMode01() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        iHello.sayHello();
    }
}
