package com.crud.jobportal.module.candidate.service;

import com.crud.jobportal.module.candidate.vo.request.CreateCandidateRequest;
import com.crud.jobportal.module.candidate.vo.request.UpdateCandidateRequest;
import com.crud.jobportal.module.candidate.vo.response.CandidateResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;


public interface CandidateService {
    CandidateResponse createCandidate(CreateCandidateRequest createCandidateRequest) throws BadRequestException;

    CandidateResponse getCandidateById(Long id) throws BadRequestException;

    CandidateResponse updateCandidate(UpdateCandidateRequest updateCandidateRequest);

    Long deleteCandidate(Long id) throws BadRequestException;

    List<CandidateResponse> getCandidates();
}
