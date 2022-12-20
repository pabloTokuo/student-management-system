package com.sms.studentmanagementsystem.resources;

import com.sms.studentmanagementsystem.entities.Student;
import com.sms.studentmanagementsystem.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Controller
public class StudentResources {

    @Autowired
    private StudentServices studentServices;

    // Show all students and return mode and view
    @GetMapping(value = "/students")
    public String findAllStudents(Model model) {
        model.addAttribute("students", studentServices.findAllStudents());
        return "students";
    }

    @GetMapping(value = "/students/new")
    public String insertStudents(Model model) {
        // Create student obj to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping(value = "/students")
    public String insertStudent(@ModelAttribute("student") Student student) {
        studentServices.insertStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentServices.findStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        // get student by id
        Student existingStudent = studentServices.findStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student obj
        studentServices.updateStudent(existingStudent.getId());
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentServices.deleteStudent(id);
        return "redirect:/students";
    }

}
