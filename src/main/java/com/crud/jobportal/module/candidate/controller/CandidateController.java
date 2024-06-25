package com.crud.jobportal.module.candidate.controller;

import com.crud.jobportal.module.candidate.service.CandidateService;
import com.crud.jobportal.module.candidate.vo.request.CreateCandidateRequest;
import com.crud.jobportal.module.candidate.vo.request.CreateCandidateSkillRequest;
import com.crud.jobportal.module.candidate.vo.request.UpdateCandidateRequest;
import com.crud.jobportal.module.candidate.vo.response.CandidateResponse;
import com.crud.jobportal.module.candidate.vo.response.CandidateSkillResponse;
import com.crud.jobportal.module.job.service.JobService;
import com.crud.jobportal.module.job.vo.response.JobResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<CandidateResponse> createCandidate(@RequestBody CreateCandidateRequest createCandidateRequest) throws BadRequestException {
        CandidateResponse candidateResponse = candidateService.createCandidate(createCandidateRequest);
            return ResponseEntity.ok().body(candidateResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getCandidateById(@PathVariable Long id) throws BadRequestException {
        CandidateResponse candidateResponse = candidateService.getCandidateById(id);
        return ResponseEntity.ok().body(candidateResponse);
    }

    @PutMapping
    public ResponseEntity<CandidateResponse> updateCandidate(@RequestBody UpdateCandidateRequest updateCandidateRequest) {
        CandidateResponse candidateResponse = candidateService.updateCandidate(updateCandidateRequest);
        return ResponseEntity.ok().body(candidateResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCandidate(@PathVariable Long id) throws BadRequestException {
        Long deletedId = candidateService.deleteCandidate(id);
        return ResponseEntity.ok().body(deletedId);
    }

    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getCandidates() {
        List<CandidateResponse> candidateResponseList = candidateService.getCandidates();
        return ResponseEntity.ok().body(candidateResponseList);
    }

    @PostMapping("/skills")
    public ResponseEntity<CandidateSkillResponse> createCandidateSkill
            (@RequestBody CreateCandidateSkillRequest createCandidateSkillRequest) {
        CandidateSkillResponse candidateSkillResponse =
                candidateService.createCandidateSkill(createCandidateSkillRequest);
        return ResponseEntity.ok().body(candidateSkillResponse);
    }

    @GetMapping("skills/{id}")
    public ResponseEntity<CandidateSkillResponse> getCandidateSkillBYId(@PathVariable Long id) {
        CandidateSkillResponse candidateSkillResponse = candidateService.getCandidateSkillById(id);
        return ResponseEntity.ok().body(candidateSkillResponse);
    }

    @GetMapping("jobs")
    public ResponseEntity<List<JobResponse>> getAllJobs() {
        List<JobResponse> jobResponseList = candidateService.getAllJobs();
        return ResponseEntity.ok().body(jobResponseList);
    }

    @DeleteMapping("skills/{id}")
    public ResponseEntity<Long> deleteCandidateSkill(@PathVariable Long id) {
        Long deletedId  = candidateService.deleteCandidateSkill(id);
        return ResponseEntity.ok().body(deletedId);
    }

}
