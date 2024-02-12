package org.example;


import org.example.model.Job;
import org.example.model.Student;
import org.example.repository.JobRepository;
import org.example.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, JobRepository jobRepository) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "Jones",
                    "maria.jones@amigoscode.edu",
                    21
            );

            Student ahmed = new Student(
                    "Ahmed",
                    "Ali",
                    "ahmed.ali@amigoscode.edu",
                    18
            );

            System.out.println("Adding maria and ahmed");
            studentRepository.saveAll(List.of(maria, ahmed));

            System.out.println(studentRepository.findAll());

            Job student = new Job("student", 0.00, 100.00);
            Job intern = new Job("intern", 0.00, 100.00);
            Job juniorDev = new Job("junior developer", 1000.00, 2000.00);
            jobRepository.saveAll(List.of(student, intern, juniorDev));

            System.out.println(jobRepository.findAll());

        };

    }

//    @Bean
//    CommandLineRunner createJobs(JobRepository jobRepository) {
//
//        return args -> {
//
//            Job student = new Job("student", 0.00, 100.00);
//            Job intern = new Job("intern", 0.00, 100.00);
//            Job juntiorDev = new Job("junior developer", 1000.00, 2000.00);
//            jobRepository.saveAll(List.of());
//
//            System.out.println(jobRepository.findAll());
//        };
//    }

}

