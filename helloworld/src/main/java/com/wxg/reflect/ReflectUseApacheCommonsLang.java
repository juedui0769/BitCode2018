package com.wxg.reflect;

import com.wxg.domain.Student;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * 2018年12月30日11:10:31
 * https://blog.csdn.net/u013510614/article/details/50481000
 */
public class ReflectUseApacheCommonsLang {
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student();
        student.setId(101);
        student.setAge(35);
        student.setName("wxg");

        System.out.println(student);

        System.out.println("\n===\n");
//        Field id = FieldUtils.getField(Student.class, "id", true);
        Object id1 = FieldUtils.readField(student, "id", true);
        System.out.println(id1);
        Object name = FieldUtils.readField(student, "name", true);
        Object age = FieldUtils.readField(student, "age", true);
        System.out.println(name);
        System.out.println(age);

        System.out.println("\n===\n");

        FieldUtils.writeField(student, "id", 113, true);
        FieldUtils.writeField(student, "name", "WangXiaogang", true);

        // Can not set java.lang.Integer field com.wxg.domain.Student.age to java.lang.String
        // FieldUtils.writeField(student, "age", "32", true);
        // 必须给出正确的类型，否则报错！
        FieldUtils.writeField(student, "age", 32, true);

        System.out.println(student);

    }
}
