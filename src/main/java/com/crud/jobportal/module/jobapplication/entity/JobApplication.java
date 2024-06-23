package com.crud.jobportal.module.jobapplication.entity;

import com.crud.jobportal.module.candidate.entity.Candidate;
import com.crud.jobportal.module.job.entity.Job;
import com.crud.jobportal.module.jobapplication.enums.JobApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private JobApplicationStatus status;
}
