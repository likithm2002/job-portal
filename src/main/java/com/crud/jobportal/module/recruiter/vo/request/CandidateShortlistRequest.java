package com.crud.jobportal.module.recruiter.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateShortlistRequest {
    private String skill;
    private Integer minimumYearsOfExperience;
}
