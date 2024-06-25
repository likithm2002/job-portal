package com.crud.jobportal.module.job.dao.impl;

import com.crud.jobportal.module.job.dao.JobDao;
import com.crud.jobportal.module.job.dto.JobDto;
import com.crud.jobportal.module.job.entity.Job;
import com.crud.jobportal.module.job.entity.QJob;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class JobDaoImpl implements JobDao {


    QJob qJob = QJob.job;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public JobDto createJob(JobDto jobDto) {
        Job job = Job.builder()
                .id(jobDto.getId())
                .name(jobDto.getName())
                .industry(jobDto.getIndustry())
                .salary(jobDto.getSalary())
                .createdAt(new Date())
                .build();

        entityManager.persist(job);

        JobDto responseJobDto = JobDto.builder()
                .id(job.getId())
                .name(job.getName())
                .industry(job.getIndustry())
                .salary(job.getSalary())
                .createdAt(new Date())
                .build();

        return responseJobDto;
    }

    @Override
    public JobDto getJobById(Long id) throws BadRequestException {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Job job = queryFactory.selectFrom(qJob)
                .where(qJob.id.eq(id))
                .fetchOne();
        if (Objects.isNull(job)) {
            throw new BadRequestException();
        }

        JobDto jobDto = JobDto.builder()
                .id(job.getId())
                .name(job.getName())
                .industry(job.getIndustry())
                .salary(job.getSalary())
                .createdAt(new Date())
                .build();

        return jobDto;
    }

    @Override
    @Transactional
    public JobDto updateJob(JobDto jobDto) {
        Job job = Job.builder()
                .id(jobDto.getId())
                .name(jobDto.getName())
                .industry(jobDto.getIndustry())
                .salary(jobDto.getSalary())
                .createdAt(new Date())
                .build();

        Job updatedJob = entityManager.merge(job);

        JobDto updatedJobDto = JobDto.builder()
                .id(updatedJob.getId())
                .name(updatedJob.getName())
                .industry(updatedJob.getIndustry())
                .salary(updatedJob.getSalary())
                .createdAt(new Date())
                .build();

        return updatedJobDto;
    }

    @Override
    @Transactional
    public JobDto deleteJob(JobDto jobDto) {
        Job job = Job.builder()
                .id(jobDto.getId())
                .name(jobDto.getName())
                .industry(jobDto.getIndustry())
                .salary(jobDto.getSalary())
                .createdAt(new Date())
                .build();

        entityManager.remove(entityManager.contains(job) ? job : entityManager.merge(job));

        JobDto responseJobDto = JobDto.builder()
                .id(job.getId())
                .name(job.getName())
                .industry(job.getIndustry())
                .salary(job.getSalary())
                .createdAt(new Date())
                .build();
        return responseJobDto;
    }

    @Override
    public List<JobDto> getAllJobs() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<Job> jobList = queryFactory.selectFrom(qJob).fetch();
        List<JobDto> jobDtoList = new ArrayList<>();
        for (Job job : jobList) {
            JobDto jobDto = JobDto.builder()
                    .id(job.getId())
                    .name(job.getName())
                    .industry(job.getIndustry())
                    .salary(job.getSalary())
                    .createdAt(new Date())
                    .build();
            jobDtoList.add(jobDto);
        }
        return jobDtoList;
    }
}
