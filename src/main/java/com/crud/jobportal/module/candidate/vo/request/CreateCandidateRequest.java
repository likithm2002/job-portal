package com.crud.jobportal.module.candidate.vo.request;

import lombok.Data;

@Data
public class CreateCandidateRequest {
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String cityName;
    private Long adminId;
}
