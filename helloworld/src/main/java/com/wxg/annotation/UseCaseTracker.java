package com.wxg.annotation;

import com.wxg.annotation.demo.PasswordUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2019年1月9日16:52:34
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.printf("Found Use Case: %s, %s\n", uc.id(), uc.desc());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }

        for (int i : useCases) {
            System.out.printf("Warning: Missing use case-%s\n", i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
