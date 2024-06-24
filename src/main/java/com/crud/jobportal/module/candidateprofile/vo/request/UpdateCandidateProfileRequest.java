package com.crud.jobportal.module.candidateprofile.vo.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UpdateCandidateProfileRequest {
    private Long id;
    private String name;
    private String qualification;
    private Integer totalYoe;
    private String languages;
    private Long candidateId;
    private Date createdAt;
}
