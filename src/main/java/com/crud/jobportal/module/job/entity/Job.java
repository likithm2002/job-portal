package com.crud.jobportal.module.job.entity;

import com.crud.jobportal.module.jobapplication.entity.JobApplication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String industry;
    private Long salary;
    private Date createdAt;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<JobApplication> jobApplicationList = new ArrayList<>();
}
