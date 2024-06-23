package com.crud.jobportal.module.recruiter.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class RecruiterDto {
    private Long id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;
    private Date createdAt;
}
