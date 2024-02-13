package org.example.repository;

import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s where s.id = ?1")
    Optional<Long> findStudentById(Long studentId);
}
