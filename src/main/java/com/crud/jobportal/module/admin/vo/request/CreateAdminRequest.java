package com.crud.jobportal.module.admin.vo.request;

import lombok.Data;

@Data
public class CreateAdminRequest {
    private String name;
    private String email;
    private String phoneNumber;
}
