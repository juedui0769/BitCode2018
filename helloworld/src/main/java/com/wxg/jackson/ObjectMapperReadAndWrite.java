package com.wxg.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wxg.domain.Student;

import java.io.IOException;

public class ObjectMapperReadAndWrite {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"id\":1, \"name\":\"wxg\", \"age\":21}";

        try {
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(student);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
