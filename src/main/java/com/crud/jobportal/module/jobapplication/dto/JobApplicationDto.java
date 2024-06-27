package com.crud.jobportal.module.jobapplication.dto;

import com.crud.jobportal.module.candidate.entity.Candidate;
import com.crud.jobportal.module.job.entity.Job;
import com.crud.jobportal.module.jobapplication.enums.JobApplicationStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JobApplicationDto {
    private Long id;
    private Candidate candidate;
    private Job job;
    private Date createdAt;
    private JobApplicationStatus status;
}
