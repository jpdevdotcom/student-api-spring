package com.example.studentcrud.student.controller;

import com.example.studentcrud.student.entity.Student;
import com.example.studentcrud.student.service.StudentService;
import com.example.studentcrud.subject.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/addAllStudents")
    public List<Student> addAllStudents(@RequestBody List<Student> students) {
        return studentService.addAllStudents(students);
    }

    @PostMapping("/{studentId}/subjects")
    public ResponseEntity<String> addSubjectToStudent(@PathVariable Long studentId, @RequestBody Subject subject) {
        Student student = studentService.addSubjectToStudent(studentId, subject);
        return ResponseEntity.ok("Subject successfully added to " + studentId);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/studentId/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable  Long studentId) {
        return studentService.deleteStudent(studentId);
    }

}
