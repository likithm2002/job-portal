package com.crud.jobportal.module.jobapplication.dao.impl;


import ch.qos.logback.core.status.Status;
import com.crud.jobportal.module.jobapplication.dao.JobApplicationDao;
import com.crud.jobportal.module.jobapplication.dto.JobApplicationDto;
import com.crud.jobportal.module.jobapplication.entity.JobApplication;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public JobApplicationDto createJobApplication(JobApplicationDto jobApplicationDto) {
        JobApplication jobApplication = JobApplication.builder()
                .id(jobApplicationDto.getId())
                .candidate(jobApplicationDto.getCandidate())
                .job(jobApplicationDto.getJob())
                .createdAt(jobApplicationDto.getCreatedAt())
                .status(jobApplicationDto.getStatus())
                .build();
        entityManager.persist(jobApplication);

        JobApplicationDto responseJobApplicationDto = JobApplicationDto.builder()
                .id(jobApplication.getId())
                .candidate(jobApplication.getCandidate())
                .job(jobApplication.getJob())
                .createdAt(jobApplication.getCreatedAt())
                .status(jobApplication.getStatus())
                .build();
        return responseJobApplicationDto;
    }
}
