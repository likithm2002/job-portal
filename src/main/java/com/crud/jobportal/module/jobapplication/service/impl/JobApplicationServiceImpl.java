package com.crud.jobportal.module.jobapplication.service.impl;

import com.crud.jobportal.module.candidate.dao.CandidateDao;
import com.crud.jobportal.module.candidate.dto.CandidateDto;
import com.crud.jobportal.module.candidate.entity.Candidate;
import com.crud.jobportal.module.job.dao.JobDao;
import com.crud.jobportal.module.job.dto.JobDto;
import com.crud.jobportal.module.job.entity.Job;
import com.crud.jobportal.module.jobapplication.dao.JobApplicationDao;
import com.crud.jobportal.module.jobapplication.dto.JobApplicationDto;
import com.crud.jobportal.module.jobapplication.enums.JobApplicationStatus;
import com.crud.jobportal.module.jobapplication.service.JobApplicationService;
import com.crud.jobportal.module.jobapplication.vo.request.CreateJobApplicationRequest;
import com.crud.jobportal.module.jobapplication.vo.response.JobApplicationResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationDao jobApplicationDao;

    @Autowired
    private CandidateDao candidateDao;

    @Autowired
    private JobDao jobDao;


    @Override
    @Transactional
    public JobApplicationResponse createJobApplication(CreateJobApplicationRequest createJobApplicationRequest) throws BadRequestException {
        CandidateDto candidateDto = candidateDao.getCandidateById(createJobApplicationRequest.getCandidateId());
        Candidate candidate = Candidate.builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .age(candidateDto.getAge())
                .email(candidateDto.getEmail())
                .phoneNumber(candidateDto.getPhoneNumber())
                .cityName(candidateDto.getCityName())
                .gender(candidateDto.getGender())
                .createdAt(candidateDto.getCreatedAt())
                .build();

        JobDto jobDto = jobDao.getJobById(createJobApplicationRequest.getJobId());
        Job job = Job.builder()
                .id(jobDto.getId())
                .name(jobDto.getName())
                .industry(jobDto.getIndustry())
                .salary(jobDto.getSalary())
                .createdAt(jobDto.getCreatedAt())
                .build();

        JobApplicationDto jobApplicationDto = JobApplicationDto.builder()
                .id(createJobApplicationRequest.getId())
                .candidate(candidate)
                .job(job)
                .createdAt(new Date())
                .status(JobApplicationStatus.valueOf(createJobApplicationRequest.getStatus()))
                .build();
        JobApplicationDto responseJobApplicationDto = jobApplicationDao.createJobApplication(jobApplicationDto);

        JobApplicationResponse jobApplicationResponse = JobApplicationResponse.builder()
                .id(responseJobApplicationDto.getId())
                .candidateId(responseJobApplicationDto.getCandidate().getId())
                .jobId(responseJobApplicationDto.getJob().getId())
                .createdAt(responseJobApplicationDto.getCreatedAt())
                .status(responseJobApplicationDto.getStatus().name())
                .build();

        return jobApplicationResponse;
    }
}
