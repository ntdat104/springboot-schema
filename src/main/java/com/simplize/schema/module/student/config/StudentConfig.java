package com.simplize.schema.module.student.config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplize.schema.module.student.model.Student;
import com.simplize.schema.module.student.repository.StudentRepository;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {

            List<Student> students = IntStream.rangeClosed(1, 1000)
                    .mapToObj(i -> new Student("student_" + i, "student_" + i + "@gmail.com", "0388422094"))
                    .collect(Collectors.toList());

            studentRepository.saveAll(students);
        };
    }

}
