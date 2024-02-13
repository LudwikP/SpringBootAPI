package org.example.controller;

import org.apache.logging.slf4j.Log4jLogger;
import org.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.example.model.Student;

import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping(path = "api/v1/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {

        logger.info("received get all students request");
        return studentService.getStudents();

    }

    @PostMapping()
    public void postStudent(@RequestBody Student student) {
        logger.info("received post student students request");
        studentService.insertStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {

        logger.info("received delete student");
        studentService.deleteStudent(studentId);

    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String email)
    {
        logger.info("received update student request");
        studentService.updateStudent(studentId, firstName, email);
    }

}
