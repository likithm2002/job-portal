package com.crud.jobportal.module.candidateprofile.service;

import com.crud.jobportal.module.candidateprofile.vo.request.CreateCandidateProfileRequest;
import com.crud.jobportal.module.candidateprofile.vo.request.UpdateCandidateProfileRequest;
import com.crud.jobportal.module.candidateprofile.vo.response.CandidateProfileResponse;
import org.apache.coyote.BadRequestException;

public interface CandidateProfileService {
    CandidateProfileResponse createCandidateProfile(CreateCandidateProfileRequest createCandidateProfileRequest);

    CandidateProfileResponse getCandidateProfileById(Long id) throws BadRequestException;

    CandidateProfileResponse updateCandidateProfile(UpdateCandidateProfileRequest updateCandidateProfileRequest);

    Long deleteCandidateProfile(Long id) throws BadRequestException;
}
