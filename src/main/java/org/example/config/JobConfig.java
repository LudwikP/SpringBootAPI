package org.example.config;

import org.example.model.Job;
import org.example.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JobConfig {

    @Bean
    CommandLineRunner insertJobsToDb(JobRepository jobRepository) {

        return args -> {
            Job student = new Job("student", 0.00, 100.00);
            Job intern = new Job("intern", 0.00, 100.00);
            Job juniorDev = new Job("junior developer", 1000.00, 2000.00);
            jobRepository.saveAll(List.of(student, intern, juniorDev));

            System.out.println(jobRepository.findAll());

        };
    }
}
