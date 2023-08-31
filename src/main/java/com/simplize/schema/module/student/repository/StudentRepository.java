package com.simplize.schema.module.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplize.schema.module.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
