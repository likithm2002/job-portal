package com.crud.jobportal.module.recruiter.dao;

import com.crud.jobportal.module.recruiter.dto.RecruiterDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface RecruiterDao {
    RecruiterDto createRecruiter(RecruiterDto recruiterDto);

    RecruiterDto getRecruiterById(Long id) throws BadRequestException;

    RecruiterDto updateRecruiter(RecruiterDto recruiterDto);

    RecruiterDto deleteRecruiter(RecruiterDto recruiterDto);

    List<RecruiterDto> getRecruiters();
}
