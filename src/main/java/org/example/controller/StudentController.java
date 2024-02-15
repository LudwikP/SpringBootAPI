package org.example.controller;

import org.apache.logging.slf4j.Log4jLogger;
import org.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.example.model.Student;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@Component

public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @RequestMapping(path = "api/v1/student", method = RequestMethod.GET)
    public ResponseEntity<String> getWelcome() {

        logger.info("received get all students request");
        return ResponseEntity.ok("This is Students service");

    }

    @RequestMapping(path = "api/v1/student/all", method = RequestMethod.GET)
    public List<Student> getAllStudents() {

        logger.info("received get all students request");
        return studentService.getStudents();

    }

    @RequestMapping(path = "api/v1/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);

    }

    @RequestMapping(path = "api/v1/student/{lastName}", method = RequestMethod.GET)
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {

        return studentService.getStudentsByLastName(lastName);

    }

    @RequestMapping(path = "api/v1/student", method = RequestMethod.POST)
    public void postStudent(@RequestBody Student student) {
        logger.info("received post student students request");
        studentService.insertStudent(student);
    }


    //http://localhost:8081/api/v1/student/info?firstName=New&lastName=Bla&email=test@test.com&age=1
    @RequestMapping(path = "api/v1/student/info", method = RequestMethod.POST)
    public void postStudentWithParams(@RequestParam(required = true) String firstName,
                                      @RequestParam(required = true) String lastName,
                                      @RequestParam(required = true) String email,
                                      @RequestParam(required = true) int age) {

        logger.info("received post student students request");
        studentService.insertStudent(new Student(firstName, lastName, email, age));

    }

    //@DeleteMapping(path = "{studentId}")
    @RequestMapping(path = "api/v1/student/{studentId}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long studentId) {

        logger.info("received delete student");
        studentService.deleteStudent(studentId);

    }

    @RequestMapping(path = "api/v1/student/{studentId}", method = RequestMethod.PUT)
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String email) {
        logger.info("received update student request");
        studentService.updateStudent(studentId, firstName, email);
    }

}
