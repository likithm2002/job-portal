package com.crud.jobportal.module.candidate.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CandidateDto {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String cityName;
    private Date createdAt;
    private Long adminId;
}
