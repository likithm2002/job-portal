package com.crud.jobportal.module.recruiter.controller;

import com.crud.jobportal.module.candidate.entity.Candidate;
import com.crud.jobportal.module.candidate.service.CandidateService;
import com.crud.jobportal.module.candidate.vo.response.CandidateSkillResponse;
import com.crud.jobportal.module.recruiter.service.RecruiterService;
import com.crud.jobportal.module.recruiter.vo.request.CandidateShortlistRequest;
import com.crud.jobportal.module.recruiter.vo.request.CreateRecruiterRequest;
import com.crud.jobportal.module.recruiter.vo.request.UpdateRecruiterRequest;
import com.crud.jobportal.module.recruiter.vo.response.RecruiterResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<RecruiterResponse> createRecruiter(@RequestBody CreateRecruiterRequest createRecruiterRequest) throws BadRequestException {
        RecruiterResponse recruiterResponse = recruiterService.createRecruiter(createRecruiterRequest);
        return ResponseEntity.ok().body(recruiterResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruiterResponse> getRecruiterById(@PathVariable Long id) throws BadRequestException {
        RecruiterResponse recruiterResponse = recruiterService.getRecruiterById(id);
        return ResponseEntity.ok().body(recruiterResponse);
    }

    @PutMapping
    public ResponseEntity<RecruiterResponse> updateRecruiter(@RequestBody UpdateRecruiterRequest updateRecruiterrequest) {
        RecruiterResponse recruiterResponse = recruiterService.updateRecruiter(updateRecruiterrequest);
        return ResponseEntity.ok().body(recruiterResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteRecruiter(@PathVariable Long id) throws BadRequestException {
        Long deletedId = recruiterService.deleteRecruiter(id);
        return ResponseEntity.ok().body(deletedId);
    }
    @GetMapping
    public ResponseEntity<List<RecruiterResponse>> getRecruiters() {
        List<RecruiterResponse> recruiterResponseList = recruiterService.getRecruiters();
        return ResponseEntity.ok().body(recruiterResponseList);
    }

    @GetMapping("/shortlist")
    public ResponseEntity<List<CandidateSkillResponse>> getShortlistedCandidates(
            @RequestParam String skill, @RequestParam Integer minimumYearsOfExperience) throws BadRequestException {
        CandidateShortlistRequest candidateShortlistRequest = CandidateShortlistRequest.builder()
                .skill(skill)
                .minimumYearsOfExperience(minimumYearsOfExperience)
                .build();
        List<CandidateSkillResponse> candidateSkillResponseList
                = recruiterService.getShortlistedCandidates(candidateShortlistRequest);
        return ResponseEntity.ok().body(candidateSkillResponseList);
    }

}