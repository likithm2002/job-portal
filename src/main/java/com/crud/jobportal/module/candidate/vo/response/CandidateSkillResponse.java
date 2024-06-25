package com.crud.jobportal.module.candidate.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkillResponse {
    private Long id;
    private String skill;
    private Integer yoe;
    private Long candidateId;
    private Date createdAt;
    private Long createdBy;
}
