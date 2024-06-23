package com.crud.jobportal.module.recruiter.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterResponse {
    private Long id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;
    private Date createdAt;
}
