package com.wxg.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxg.domain.Student;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonWithMap {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> dataMap = new HashMap<>();
        int[] marks = {1, 2, 3};

        Student student = new Student();
        student.setId(102);
        student.setName("wxg");
        student.setAge(36);

        dataMap.put("student", student);
        dataMap.put("name", "WangXiaoGang");
        dataMap.put("verified", Boolean.FALSE);
        dataMap.put("marks", marks);

        File file = new File("datamap.json");
        System.out.println(file.getAbsolutePath());
        mapper.writeValue(file, dataMap);

        Map map = mapper.readValue(file, Map.class);

        System.out.println(map.get("student"));
        System.out.println(map.get("name"));
        System.out.println(map.get("verified"));
        System.out.println(map.get("marks"));

    }
}
