package com.crud.jobportal.module.jobapplication.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateJobApplicationRequest {
    private Long id;
    private Long candidateId;
    private Long jobId;
    private String status;
}
