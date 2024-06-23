package com.crud.jobportal.module.job.service.impl;

import com.crud.jobportal.module.job.dao.JobDao;
import com.crud.jobportal.module.job.dto.JobDto;
import com.crud.jobportal.module.job.service.JobService;
import com.crud.jobportal.module.job.vo.request.CreateJobRequest;
import com.crud.jobportal.module.job.vo.request.UpdateJobRequest;
import com.crud.jobportal.module.job.vo.response.JobResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public JobResponse createJob(CreateJobRequest createJobRequest) {
        JobDto jobDto = JobDto.builder()
                .id(createJobRequest.getId())
                .name(createJobRequest.getName())
                .industry(createJobRequest.getIndustry())
                .salary(createJobRequest.getSalary())
                .createdAt(new Date())
                .build();
        JobDto responseJobDto = jobDao.createJob(jobDto);

        JobResponse jobResponse = JobResponse.builder()
                .id(responseJobDto.getId())
                .name(responseJobDto.getName())
                .industry(responseJobDto.getIndustry())
                .salary(responseJobDto.getSalary())
                .createdAt(new Date())
                .build();

        return jobResponse;
    }

    @Override
    public JobResponse getJobById(Long id) throws BadRequestException {
        JobDto jobDto = jobDao.getJobById(id);

        JobResponse jobResponse = JobResponse.builder()
                .id(jobDto.getId())
                .name(jobDto.getName())
                .industry(jobDto.getIndustry())
                .salary(jobDto.getSalary())
                .createdAt(new Date())
                .build();

        return jobResponse;
    }

    @Override
    @Transactional
    public JobResponse updateJob(UpdateJobRequest updateJobRequest) {
        JobDto jobDto = JobDto.builder()
                .id(updateJobRequest.getId())
                .name(updateJobRequest.getName())
                .industry(updateJobRequest.getIndustry())
                .salary(updateJobRequest.getSalary())
                .createdAt(new Date())
                .build();
        JobDto responseJobDto = jobDao.updateJob(jobDto);

        JobResponse jobResponse = JobResponse.builder()
                .id(responseJobDto.getId())
                .name(responseJobDto.getName())
                .industry(responseJobDto.getIndustry())
                .salary(responseJobDto.getSalary())
                .createdAt(new Date())
                .build();

        return jobResponse;
    }

    @Override
    @Transactional
    public Long deleteJob(Long id) throws BadRequestException {
        JobResponse jobResponse = this.getJobById(id);

        JobDto jobDto = JobDto.builder()
                .id(jobResponse.getId())
                .name(jobResponse.getName())
                .industry(jobResponse.getIndustry())
                .salary(jobResponse.getSalary())
                .createdAt(new Date())
                .build();
        JobDto deleteJobDto = jobDao.deleteJob(jobDto);

        return deleteJobDto.getId();
    }
}
