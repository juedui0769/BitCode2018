package com.wxg.reflect;

import com.wxg.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectUtilTest {

    @Test
    public void testGetAndSet() {
        Student student = new Student();
        student.setId(101);
        student.setAge(35);
        student.setName("wxg");

        // === get

        Object id = ReflectUtil.getFieldValue(student, "id");
        Object name = ReflectUtil.getFieldValue(student, "name");
        Object age = ReflectUtil.getFieldValue(student, "age");

        Assert.assertEquals(101, Integer.parseInt(id.toString()));
        Assert.assertEquals("wxg", name.toString());
        Assert.assertEquals(35, Integer.parseInt(age.toString()));

        // === set , 无法设置 `Integer`值

        ReflectUtil.setFieldValue(student, "id", "102");
        ReflectUtil.setFieldValue(student, "name", "WangXiaoGang");
        ReflectUtil.setFieldValue(student, "age", "34");

        System.out.println(student);
    }
}