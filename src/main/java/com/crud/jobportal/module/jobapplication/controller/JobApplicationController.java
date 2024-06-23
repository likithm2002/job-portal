package com.crud.jobportal.module.jobapplication.controller;

import com.crud.jobportal.module.jobapplication.service.JobApplicationService;
import com.crud.jobportal.module.jobapplication.vo.request.CreateJobApplicationRequest;
import com.crud.jobportal.module.jobapplication.vo.response.JobApplicationResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/jobapplications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;


    @PostMapping
    public ResponseEntity<JobApplicationResponse> createJobApplication
            (@RequestBody CreateJobApplicationRequest createJobApplicationRequest) throws BadRequestException {
        JobApplicationResponse jobApplicationResponse =
                jobApplicationService.createJobApplication(createJobApplicationRequest);
        return ResponseEntity.ok().body(jobApplicationResponse);
    }
}
