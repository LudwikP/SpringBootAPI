package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    StudentRepository studentRepository;

    public void deleteStudent(Long studentId) {

        logger.info("Deleting student - checking if student exits");

        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id of " + studentId + " does not exists");
        }
        logger.info("Student exists");
        try {
            studentRepository.deleteById(studentId);
            logger.info("Student deleted");
        } catch (Exception e) {
            logger.info("Student cannot be deleted " + e.getMessage());
        }

    }

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void insertStudent(Student student) {

        checkIfEmailPatternCorrect(student.getEmail());

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {

            throw new IllegalStateException("The student with the email of: " + student.getEmail() + " exists");
        }

        studentRepository.save(student);

    }

    @Transactional
    public void updateStudent(Long studentId, String firstName, String email) {

        logger.info("validating update request");
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("No student with the id of " + studentId));

        if (firstName != null && !firstName.isEmpty() && !Objects.equals(student.getFirstName(), firstName)) {

            student.setFirstName(firstName);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }

        if (email != null) {
            validateEmail(email);
        }

        logger.info("updating student");
        studentRepository.save(student);
    }

    private void validateEmail(String email) {

        checkIfEmailPatternCorrect(email);
        checkIfEmailTaken(email);
    }

    private void checkIfEmailPatternCorrect(String email) {

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (!Pattern.compile(regexPattern).matcher(email).matches()) {
            throw new IllegalStateException(email + " email is invalid");
        }
        ;

    }

    private void checkIfEmailTaken(String email) {

        if (studentRepository.findStudentByEmail(email).isPresent()) {
            throw new IllegalStateException("Cannot update email " + email + " is taken");
        }
        ;
    }

    public Student getStudentById(Long id) {

        Optional<Student> studentOptional = studentRepository.findStudentById(id);

        if(studentOptional.isEmpty())
        {
            throw new IllegalStateException("No student found");
        }

        return studentOptional.get();

    }

    public List<Student> getStudentsByLastName(String lastName) {

        Optional<List<Student>> studentsOptional = studentRepository.findStudentsByLastName(lastName);
        if(studentsOptional.isEmpty()) {
            throw new IllegalStateException("No students with the last name of " + lastName);

        }
        return studentsOptional.get();
    }
}
