package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {

        List<Student> students = studentRepository.findAll();
        return students;
    }
}
