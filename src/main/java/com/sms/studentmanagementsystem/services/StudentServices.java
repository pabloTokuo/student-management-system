package com.sms.studentmanagementsystem.services;

import com.sms.studentmanagementsystem.entities.Student;
import com.sms.studentmanagementsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    public StudentRepository studentRepository;

    //Find Student
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    //Insert Student
    public Student insertStudent(Student obj) {
        return studentRepository.save(obj);
    }

    // Find Student byId
    public Student findStudentById(Long id) {
        Optional<Student> obj = studentRepository.findById(id);
        return obj.orElseThrow();
    }

    // Update Student byID
    public Student updateStudent(Long id) {
        Student entity = studentRepository.getReferenceById(id);
        return studentRepository.save(entity);
    }

    // Delete Student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
