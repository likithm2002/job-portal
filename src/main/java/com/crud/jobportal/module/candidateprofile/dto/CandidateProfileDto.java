package com.crud.jobportal.module.candidateprofile.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CandidateProfileDto {
    private Long id;
    private String name;
    private String qualification;
    private Integer totalYoe;
    private String languages;
    private Long candidateId;
    private Date createdAt;
}
