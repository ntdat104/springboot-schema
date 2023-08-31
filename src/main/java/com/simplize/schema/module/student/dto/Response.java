package com.simplize.schema.module.student.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private Integer status;
    private String code;
    private String message;
    private Long total;
    private T data;

    public Response(T data) {
        this.data = data;
        this.status = HttpStatus.OK.value();
        this.message = "Success";
    }

    public Response(T data, Long total) {
        this.data = data;
        this.status = HttpStatus.OK.value();
        this.message = "Success";
        this.total = total;
    }

    public static <T> Response<T> data(T data) {
        return new Response<T>(data);
    }

    public static <T> Response<T> findAll(T data, Long total) {
        return new Response<T>(data, total);
    }
}
