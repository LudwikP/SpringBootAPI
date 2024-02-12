package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {

        List<Student> students = studentRepository.findAll();
        return students;
    }

    public void insertStudent(Student student) {

        studentRepository.save(student);
        System.out.println("inserting student: " + student);
    }
}
