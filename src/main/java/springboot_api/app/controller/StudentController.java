package springboot_api.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_api.app.Student;
import springboot_api.app.StudentRepository;

import java.util.List;

@RestController
@Component
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping()
    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        return students;
    }


}
