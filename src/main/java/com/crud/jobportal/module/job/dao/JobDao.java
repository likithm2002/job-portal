package com.crud.jobportal.module.job.dao;

import com.crud.jobportal.module.job.dto.JobDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface JobDao {
    JobDto createJob(JobDto jobDto);

    JobDto getJobById(Long id) throws BadRequestException;

    JobDto updateJob(JobDto jobDto);

    JobDto deleteJob(JobDto jobDto);

    List<JobDto> getAllJobs();
}
