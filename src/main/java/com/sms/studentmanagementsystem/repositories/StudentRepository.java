package com.sms.studentmanagementsystem.repositories;

import com.sms.studentmanagementsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
