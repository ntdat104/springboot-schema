package com.simplize.schema.module.student.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedBy
    @Column(name = "created_id")
    @JsonIgnore
    private Long createdId;

    @CreatedDate
    @Column(name = "created_date")
    @JsonIgnore
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "modified_id")
    @JsonIgnore
    private Long modifiedId;

    @LastModifiedDate
    @Column(name = "modified_date")
    @JsonIgnore
    private Date modifiedDate;

}
