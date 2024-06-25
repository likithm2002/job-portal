package com.crud.jobportal.module.candidate.dao;

import com.crud.jobportal.module.candidate.dto.CandidateSkillDto;
import com.crud.jobportal.module.recruiter.vo.request.CandidateShortlistRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CandidateSkillDao {

    CandidateSkillDto createCandidateSkill(CandidateSkillDto candidateSkillDto);

    CandidateSkillDto getCandidateSkillById(Long id);

    List<CandidateSkillDto> getShortlistedCandidates(CandidateShortlistRequest candidateShortlistRequest);

    CandidateSkillDto deleteCandidateSkill(CandidateSkillDto candidateSkillDto);
}
