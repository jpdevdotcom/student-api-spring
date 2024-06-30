package com.example.studentcrud.subject.repository;

import com.example.studentcrud.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
