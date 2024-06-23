package com.crud.jobportal.module.job.service;

import com.crud.jobportal.module.job.vo.request.CreateJobRequest;
import com.crud.jobportal.module.job.vo.request.UpdateJobRequest;
import com.crud.jobportal.module.job.vo.response.JobResponse;
import org.apache.coyote.BadRequestException;

public interface JobService {
    JobResponse createJob(CreateJobRequest createJobRequest);

    JobResponse getJobById(Long id) throws BadRequestException;

    JobResponse updateJob(UpdateJobRequest updateJobRequest);

    Long deleteJob(Long id) throws BadRequestException;
}
