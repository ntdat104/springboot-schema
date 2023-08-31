package com.simplize.schema.module.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.simplize.schema.module.student.dto.Response;
import com.simplize.schema.module.student.model.Student;
import com.simplize.schema.module.student.repository.StudentRepository;
import com.simplize.schema.module.student.service.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Response<?> findAll(Integer page, Integer size, String sort, String direction) {
        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Direction.ASC, "id"));
        Page<Student> result = repository.findAll(pageable);
        return Response.findAll(result.getContent(), result.getTotalElements());
    }

    @Override
    public Response<?> create(Student create) {
        return Response.data(repository.save(create));
    }
}
