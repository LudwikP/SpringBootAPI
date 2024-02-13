package org.example.repository;

import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s where s.id = ?1")
    Optional<Student> findStudentById(Long studentId);

    @Query("SELECT s FROM Student s where s.lastname = ?1")
    Optional<List<Student>> findStudentsByLastName(String lastName);
}
