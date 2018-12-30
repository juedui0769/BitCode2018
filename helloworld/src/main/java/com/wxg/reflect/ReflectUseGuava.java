package com.wxg.reflect;

import com.google.common.reflect.Invokable;
import com.wxg.domain.Student;

/**
 * 2018年12月30日10:44:20
 * http://wiki.jikexueyuan.com/project/google-guava-official-tutorial/reflection.html
 *
 */
public class ReflectUseGuava {

    /**
     * {@link Invokable}
     * @param args
     */
    public static void main(String[] args) {

        Student student = new Student();
        student.setId(101);
        student.setAge(35);
        student.setName("wxg");

        System.out.println(student);

    }

    /**
     * https://qinjiangbo.com/guava-reflection-21.html
     */
    public static void test01() {
//        Invokable.from()
    }
}
