package com.crud.jobportal.module.recruiter.service;

import com.crud.jobportal.module.candidate.vo.response.CandidateResponse;
import com.crud.jobportal.module.candidate.vo.response.CandidateSkillResponse;
import com.crud.jobportal.module.recruiter.vo.request.CandidateShortlistRequest;
import com.crud.jobportal.module.recruiter.vo.request.CreateRecruiterRequest;
import com.crud.jobportal.module.recruiter.vo.request.UpdateRecruiterRequest;
import com.crud.jobportal.module.recruiter.vo.response.RecruiterResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface RecruiterService {
    RecruiterResponse createRecruiter(CreateRecruiterRequest createRecruiterRequest) throws BadRequestException;

    RecruiterResponse getRecruiterById(Long id) throws BadRequestException;

    RecruiterResponse updateRecruiter(UpdateRecruiterRequest updateRecruiterrequest);

    Long deleteRecruiter(Long id) throws BadRequestException;

    List<RecruiterResponse> getRecruiters();

    List<CandidateSkillResponse> getShortlistedCandidates(CandidateShortlistRequest candidateShortlistRequest)
            throws BadRequestException;

}
