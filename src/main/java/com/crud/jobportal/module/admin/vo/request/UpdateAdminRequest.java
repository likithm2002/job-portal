package com.crud.jobportal.module.admin.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateAdminRequest {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date createdAt;
}
