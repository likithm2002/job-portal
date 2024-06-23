package com.crud.jobportal.module.recruiter.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateRecruiterRequest {
    private Long id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;
    private Date createdAt;
}
