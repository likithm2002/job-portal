package com.crud.jobportal.module.candidate.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateCandidateRequest {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String phoneNumber;
    private String cityName;
    private Date createdAt;
}
