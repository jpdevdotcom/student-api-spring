package com.example.studentcrud.student.service;

import com.example.studentcrud.student.entity.Student;
import com.example.studentcrud.student.repository.StudentRepository;
import com.example.studentcrud.subject.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> addAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student addSubjectToStudent(Long studentId, Subject subject) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        subject.setStudent(student);
        student.getSubjects().add(subject);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getStudent_id()).orElse(null);

        if (existingStudent != null) {
            existingStudent.setFirstname(student.getFirstname());
            existingStudent.setLastname(student.getLastname());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setYear_level(student.getYear_level());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    public String deleteStudent(long id) {
        studentRepository.deleteById(id);

        return "Student " + id + " has been deleted!";
    }
}
