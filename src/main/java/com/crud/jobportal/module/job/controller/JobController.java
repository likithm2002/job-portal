package com.crud.jobportal.module.job.controller;

import com.crud.jobportal.module.job.service.JobService;
import com.crud.jobportal.module.job.vo.request.CreateJobRequest;
import com.crud.jobportal.module.job.vo.request.UpdateJobRequest;
import com.crud.jobportal.module.job.vo.response.JobResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<JobResponse> createJob(@RequestBody CreateJobRequest createJobRequest) {
        JobResponse jobResponse = jobService.createJob(createJobRequest);
        return ResponseEntity.ok().body(jobResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJobById(@PathVariable Long id) throws BadRequestException {
        JobResponse jobResponse = jobService.getJobById(id);
        return ResponseEntity.ok().body(jobResponse);
    }

    @PutMapping
    public ResponseEntity<JobResponse> updateJob(@RequestBody UpdateJobRequest updateJobRequest) {
        JobResponse jobResponse = jobService.updateJob(updateJobRequest);
        return ResponseEntity.ok().body(jobResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteJob(@PathVariable Long id) throws BadRequestException {
        Long deletedId = jobService.deleteJob(id);
        return ResponseEntity.ok().body(deletedId);
    }
}
