package com.crud.jobportal.module.recruiter.service.impl;

import com.crud.jobportal.module.candidate.dao.CandidateSkillDao;
import com.crud.jobportal.module.candidate.dto.CandidateSkillDto;
import com.crud.jobportal.module.candidate.vo.response.CandidateSkillResponse;
import com.crud.jobportal.module.recruiter.dao.RecruiterDao;
import com.crud.jobportal.module.recruiter.dto.RecruiterDto;
import com.crud.jobportal.module.recruiter.service.RecruiterService;
import com.crud.jobportal.module.recruiter.vo.request.CandidateShortlistRequest;
import com.crud.jobportal.module.recruiter.vo.request.CreateRecruiterRequest;
import com.crud.jobportal.module.recruiter.vo.request.UpdateRecruiterRequest;
import com.crud.jobportal.module.recruiter.vo.response.RecruiterResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterDao recruiterDao;

    @Autowired
    private CandidateSkillDao candidateSkillDao;

    @Override
    @Transactional
    public RecruiterResponse createRecruiter(CreateRecruiterRequest createRecruiterRequest) throws BadRequestException {
        RecruiterDto recruiterDto = RecruiterDto.builder()
                .id(createRecruiterRequest.getId())
                .name(createRecruiterRequest.getName())
                .email(createRecruiterRequest.getEmail())
                .companyName(createRecruiterRequest.getCompanyName())
                .phoneNumber(createRecruiterRequest.getPhoneNumber())
                .createdAt(new Date())
                .adminId(createRecruiterRequest.getAdminId())
                .build();
        RecruiterDto responseRecruiterDto = recruiterDao.createRecruiter(recruiterDto);

        RecruiterResponse recruiterResponse = RecruiterResponse.builder()
                .id(responseRecruiterDto.getId())
                .name(responseRecruiterDto.getCompanyName())
                .email(responseRecruiterDto.getEmail())
                .companyName(responseRecruiterDto.getCompanyName())
                .phoneNumber(createRecruiterRequest.getPhoneNumber())
                .createdAt(new Date())
                .build();
        return recruiterResponse;
    }

    @Override
    public RecruiterResponse getRecruiterById(Long id) throws BadRequestException {
        RecruiterDto recruiterDto = recruiterDao.getRecruiterById(id);
        RecruiterResponse recruiterResponse = RecruiterResponse.builder()
                .id(recruiterDto.getId())
                .name(recruiterDto.getName())
                .email(recruiterDto.getEmail())
                .companyName(recruiterDto.getCompanyName())
                .phoneNumber(recruiterDto.getPhoneNumber())
                .createdAt(new Date())
                .build();
        return recruiterResponse;
    }

    @Override
    @Transactional
    public RecruiterResponse updateRecruiter(UpdateRecruiterRequest updateRecruiterrequest) {
        RecruiterDto recruiterDto = RecruiterDto.builder()
                .id(updateRecruiterrequest.getId())
                .name(updateRecruiterrequest.getName())
                .email(updateRecruiterrequest.getEmail())
                .companyName(updateRecruiterrequest.getCompanyName())
                .phoneNumber(updateRecruiterrequest.getPhoneNumber())
                .createdAt(new Date())
                .build();
       RecruiterDto responseRecruiterDto = recruiterDao.updateRecruiter(recruiterDto);

       RecruiterResponse recruiterResponse = RecruiterResponse.builder()
               .id(responseRecruiterDto.getId())
               .name(responseRecruiterDto.getName())
               .email(responseRecruiterDto.getEmail())
               .companyName(responseRecruiterDto.getCompanyName())
               .phoneNumber(responseRecruiterDto.getPhoneNumber())
               .createdAt(new Date())
               .build();
        return recruiterResponse;
    }

    @Override
    @Transactional
    public Long deleteRecruiter(Long id) throws BadRequestException {
        RecruiterResponse recruiterResponse = this.getRecruiterById(id);
        RecruiterDto recruiterDto = RecruiterDto.builder()
                .id(recruiterResponse.getId())
                .name(recruiterResponse.getCompanyName())
                .email(recruiterResponse.getEmail())
                .companyName(recruiterResponse.getCompanyName())
                .phoneNumber(recruiterResponse.getPhoneNumber())
                .createdAt(recruiterResponse.getCreatedAt())
                .build();

        RecruiterDto deleteRecruiterDto = recruiterDao.deleteRecruiter(recruiterDto);
        return deleteRecruiterDto.getId();
    }

    @Override
    public List<RecruiterResponse> getRecruiters() {
        List<RecruiterDto> recruiterDtoList = recruiterDao.getRecruiters();
        List<RecruiterResponse> recruiterResponseList = new ArrayList<>();

        for (RecruiterDto recruiterDto : recruiterDtoList) {
            RecruiterResponse recruiterResponse = RecruiterResponse.builder()
                    .id(recruiterDto.getId())
                    .name(recruiterDto.getName())
                    .email(recruiterDto.getEmail())
                    .companyName(recruiterDto.getCompanyName())
                    .phoneNumber(recruiterDto.getPhoneNumber())
                    .createdAt(new Date())
                    .build();
            recruiterResponseList.add(recruiterResponse);
        }
        return recruiterResponseList;
    }


    @Override
    public List<CandidateSkillResponse> getShortlistedCandidates(CandidateShortlistRequest candidateShortlistRequest) {
        List<CandidateSkillDto> candidateSkillDtoList = candidateSkillDao.getShortlistedCandidates(candidateShortlistRequest);
        List<CandidateSkillResponse> candidateSkillResponseList = new ArrayList<>();

        for (CandidateSkillDto candidateSkillDto : candidateSkillDtoList) {
            CandidateSkillResponse candidateSkillResponse = CandidateSkillResponse.builder()
                    .id(candidateSkillDto.getId())
                    .skill(candidateSkillDto.getSkill())
                    .yoe(candidateSkillDto.getYoe())
                    .candidateId(candidateSkillDto.getCandidateId())
                    .createdAt(candidateSkillDto.getCreatedAt())
                    .createdBy(candidateSkillDto.getCreatedBy())
                    .build();
            candidateSkillResponseList.add(candidateSkillResponse);
        }
        return candidateSkillResponseList;
    }
}
