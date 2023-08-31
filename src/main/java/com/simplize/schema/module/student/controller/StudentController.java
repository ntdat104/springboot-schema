package com.simplize.schema.module.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.schema.module.student.dto.Response;
import com.simplize.schema.module.student.model.Student;
import com.simplize.schema.module.student.service.impl.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Response<?> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String direction) {
        return studentService.findAll(page, size, sort, direction);
    }

    @PostMapping
    public Response<?> create(@RequestBody Student create) {
        return studentService.create(create);
    }

}
