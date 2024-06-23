package com.crud.jobportal.module.jobapplication.dao;

import com.crud.jobportal.module.jobapplication.dto.JobApplicationDto;

public interface JobApplicationDao {
    JobApplicationDto createJobApplication(JobApplicationDto jobApplicationDto);
}
