package com.crud.jobportal.module.candidateprofile.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateProfileResponse {
    private Long id;
    private String name;
    private String qualification;
    private Integer totalYoe;
    private String languages;
    private Long candidateId;
    private Date createdAt;
}
