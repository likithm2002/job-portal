package com.crud.jobportal.module.recruiter.dao;

import com.crud.jobportal.module.candidate.dto.CandidateDto;
import com.crud.jobportal.module.recruiter.dto.RecruiterDto;
import com.crud.jobportal.module.recruiter.vo.request.CandidateShortlistRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface RecruiterDao {
    RecruiterDto createRecruiter(RecruiterDto recruiterDto) throws BadRequestException;

    RecruiterDto getRecruiterById(Long id) throws BadRequestException;

    RecruiterDto updateRecruiter(RecruiterDto recruiterDto);

    RecruiterDto deleteRecruiter(RecruiterDto recruiterDto);

    List<RecruiterDto> getRecruiters();

}
