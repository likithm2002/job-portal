package com.crud.jobportal.module.job.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateJobRequest {
    private Long id;
    private String name;
    private String industry;
    private Long salary;
    private Date createdAt;
}
