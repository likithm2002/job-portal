package com.crud.jobportal.module.jobapplication.service;

import com.crud.jobportal.module.jobapplication.vo.request.CreateJobApplicationRequest;
import com.crud.jobportal.module.jobapplication.vo.response.JobApplicationResponse;
import org.apache.coyote.BadRequestException;

public interface JobApplicationService {
    JobApplicationResponse createJobApplication(CreateJobApplicationRequest createJobApplicationRequest) throws BadRequestException;
}
