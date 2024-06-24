package com.crud.jobportal.module.candidateprofile.controller;

import com.crud.jobportal.module.candidateprofile.service.CandidateProfileService;
import com.crud.jobportal.module.candidateprofile.vo.request.CreateCandidateProfileRequest;
import com.crud.jobportal.module.candidateprofile.vo.request.UpdateCandidateProfileRequest;
import com.crud.jobportal.module.candidateprofile.vo.response.CandidateProfileResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/candidateprofiles")
public class CandidateProfileController {

    @Autowired
    private CandidateProfileService candidateProfileService;

    @PostMapping
    public ResponseEntity<CandidateProfileResponse> createCandidateProfile
            (@RequestBody CreateCandidateProfileRequest createCandidateProfilRequest) {
        CandidateProfileResponse candidateProfileResponse =
                candidateProfileService.createCandidateProfile(createCandidateProfilRequest);
        return ResponseEntity.ok().body(candidateProfileResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateProfileResponse> getCandidateProfileById(@PathVariable Long id) throws BadRequestException {
        CandidateProfileResponse candidateProfileResponse = candidateProfileService.getCandidateProfileById(id);
        return ResponseEntity.ok().body(candidateProfileResponse);
    }

    @PutMapping
    public ResponseEntity<CandidateProfileResponse> updateCandidateProfile
            (@RequestBody UpdateCandidateProfileRequest updateCandidateProfileRequest) {
        CandidateProfileResponse candidateProfileResponse =
                candidateProfileService.updateCandidateProfile(updateCandidateProfileRequest);
        return new ResponseEntity<>(candidateProfileResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCandidateProfile(@PathVariable Long id) {
        Long deletedId = candidateProfileService.deleteCandidateProfile(id);
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }
}
