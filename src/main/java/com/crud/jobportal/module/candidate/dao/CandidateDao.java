package com.crud.jobportal.module.candidate.dao;

import com.crud.jobportal.module.candidate.dto.CandidateDto;
import org.apache.coyote.BadRequestException;

public interface CandidateDao {
    CandidateDto createCandidate(CandidateDto candidateDto);

    CandidateDto getAdminById(Long id) throws BadRequestException;

    CandidateDto updateCandidate(CandidateDto candidateDto);

    CandidateDto deletedCandidate(CandidateDto candidateDto);
}
