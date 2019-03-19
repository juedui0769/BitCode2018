package com.wxg.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxg.domain.Student;

import java.io.File;
import java.io.IOException;

public class ReadAndWriteWithFile {

    private ObjectMapper mapper;

    public ReadAndWriteWithFile() {
        mapper = new ObjectMapper();
    }

    public static void main(String[] args) throws IOException {
        ReadAndWriteWithFile withFile = new ReadAndWriteWithFile();

        Student student = new Student();
        student.setId(101);
        student.setName("wxg");
        student.setAge(35);

        withFile.writeJSON(student);

        Student student1 = withFile.readJSON();
        System.out.println(student1);
    }

    private Student readJSON() throws IOException {
        // `user.dir` 是不确定的，特别是打包成jar文件之后……
        // new File(System.getProperty("user.dir"));
        File file = new File("student.json");
        System.out.println(file.getAbsolutePath());
        Student student = mapper.readValue(file, Student.class);
        return student;
    }

    private void writeJSON(Student student) throws IOException {
        mapper.writeValue(new File("student.json"), student);
    }
}
