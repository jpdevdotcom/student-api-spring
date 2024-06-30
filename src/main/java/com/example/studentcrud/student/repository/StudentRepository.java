package com.example.studentcrud.student.repository;

import com.example.studentcrud.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
