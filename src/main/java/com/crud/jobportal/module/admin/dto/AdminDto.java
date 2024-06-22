package com.crud.jobportal.module.admin.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AdminDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date createdAt;
}
