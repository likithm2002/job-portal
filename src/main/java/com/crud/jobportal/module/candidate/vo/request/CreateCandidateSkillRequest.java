package com.crud.jobportal.module.candidate.vo.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateCandidateSkillRequest {
    private Long id;
    private String skill;
    private Integer yoe;
    private Long candidateId;
    private Date createdAt;
    private Long createdBy;
}
