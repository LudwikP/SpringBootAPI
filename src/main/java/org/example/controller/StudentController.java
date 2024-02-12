package org.example.controller;

import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.example.model.Student;

import java.util.List;

@RestController
@Component
@RequestMapping(path = "api/v1/student")
public class StudentController {

@Autowired
    StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {

        return studentService.getStudents();

    }

    @PostMapping()
    public void postStudent(@RequestBody Student student) {

        studentService.insertStudent(student);
    }


}
