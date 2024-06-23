package com.crud.jobportal.module.job.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JobDto {
    private Long id;
    private String name;
    private String industry;
    private Long salary;
    private Date createdAt;
}
