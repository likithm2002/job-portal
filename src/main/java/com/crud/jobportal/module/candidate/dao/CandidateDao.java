package com.crud.jobportal.module.candidate.dao;

import com.crud.jobportal.module.candidate.dto.CandidateDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CandidateDao {
    CandidateDto createCandidate(CandidateDto candidateDto) throws BadRequestException;

    CandidateDto getCandidateById(Long id) throws BadRequestException;

    CandidateDto updateCandidate(CandidateDto candidateDto);

    CandidateDto deleteCandidate(CandidateDto candidateDto);

    List<CandidateDto> getCandidates();

    List<CandidateDto> getAllCandidates();

    ;
}
