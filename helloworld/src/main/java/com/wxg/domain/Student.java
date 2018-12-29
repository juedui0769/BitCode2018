package com.wxg.domain;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer age;
    private Integer id;

    public Student() {
    }

    public Student(String name, Integer age, Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
}
