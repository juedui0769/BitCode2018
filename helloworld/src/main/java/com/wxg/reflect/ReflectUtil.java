package com.wxg.reflect;

import java.lang.reflect.Field;

/**
 * 2018年12月29日21:08:23
 * from `crt-apiinterface`
 *
 * `com.wxg.reflect.ReflectUtilTest` , 是测试， 有弊端： 只能设置`String`类型的值。
 * 正确的方式是 {@link ReflectUseApacheCommonsLang}
 */
public final class ReflectUtil {
    /**
     * 利用反射获取指定对象的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException e) {
                System.err.printf("IllegalArgumentException, %s", e);
            } catch (IllegalAccessException e) {
                System.err.printf("IllegalAccessException, %s", e);
            }
        }
        return result;
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     *
     * @param obj        目标对象
     * @param fieldName  目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName,
                                     String fieldValue) {
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalArgumentException e) {
                System.err.printf("IllegalArgumentException, %s", e);
            } catch (IllegalAccessException e) {
                System.err.printf("IllegalAccessException, %s", e);
            }
        }
    }
}
