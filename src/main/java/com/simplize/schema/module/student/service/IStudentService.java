package com.simplize.schema.module.student.service;

import com.simplize.schema.module.student.dto.Response;
import com.simplize.schema.module.student.model.Student;

public interface IStudentService {
    Response<?> findAll(Integer page, Integer size, String sort, String direction);

    Response<?> create(Student create);
}
