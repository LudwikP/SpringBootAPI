package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.Student;
import org.example.StudentRepository;

import java.util.List;

@RestController
@Component
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping()
    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        return students;
    }


}
