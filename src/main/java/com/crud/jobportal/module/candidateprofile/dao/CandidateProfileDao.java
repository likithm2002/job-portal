package com.crud.jobportal.module.candidateprofile.dao;

import com.crud.jobportal.module.candidateprofile.dto.CandidateProfileDto;
import com.crud.jobportal.module.candidateprofile.vo.response.CandidateProfileResponse;
import org.apache.coyote.BadRequestException;

public interface CandidateProfileDao {
    CandidateProfileDto createCandidateProfile(CandidateProfileDto candidateProfileDto);

    CandidateProfileDto getCandidateProfileById(Long id) throws BadRequestException;

    CandidateProfileResponse updateCandidateProfile(CandidateProfileDto updateCandidateProfile);

    CandidateProfileDto deleteCandidateProfile(CandidateProfileDto candidateProfileDto);
}
