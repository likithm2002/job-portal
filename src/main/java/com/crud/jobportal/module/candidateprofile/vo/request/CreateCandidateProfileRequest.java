package com.crud.jobportal.module.candidateprofile.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateCandidateProfileRequest {
    private Long id;
    private String name;
    private String qualification;
    private Integer totalYoe;
    private String languages;
    private Long candidateId;
    private Date createdAt;
}
