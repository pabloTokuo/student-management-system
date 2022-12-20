package com.sms.studentmanagementsystem.config;

import com.sms.studentmanagementsystem.entities.Student;
import com.sms.studentmanagementsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
//@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
/*
        studentRepository.deleteAll();

        Student s1 = new Student(null, "Pablo", "Tokuo", "pablo@gmail.com");
        Student s2 = new Student(null, "Bob", "Bobes", "bob@gmail.com");
        Student s3 = new Student(null, "Alex", "Green", "alex@gmail.com");

        studentRepository.saveAll(Arrays.asList(s1, s2, s3));
 */

    }
}
