package com.crud.jobportal.module.candidateprofile.service.impl;

import com.crud.jobportal.module.candidateprofile.dao.CandidateProfileDao;
import com.crud.jobportal.module.candidateprofile.dto.CandidateProfileDto;
import com.crud.jobportal.module.candidateprofile.service.CandidateProfileService;
import com.crud.jobportal.module.candidateprofile.vo.request.CreateCandidateProfileRequest;
import com.crud.jobportal.module.candidateprofile.vo.request.UpdateCandidateProfileRequest;
import com.crud.jobportal.module.candidateprofile.vo.response.CandidateProfileResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CandidateProfileServiceImpl implements CandidateProfileService {

    @Autowired
    private CandidateProfileDao candidateProfileDao;

    @Override
    @Transactional
    public CandidateProfileResponse createCandidateProfile(CreateCandidateProfileRequest createCandidateProfileRequest) {
        CandidateProfileDto candidateProfileDto = CandidateProfileDto.builder()
                .id(createCandidateProfileRequest.getId())
                .name(createCandidateProfileRequest.getName())
                .qualification(createCandidateProfileRequest.getQualification())
                .totalYoe(createCandidateProfileRequest.getTotalYoe())
                .languages(createCandidateProfileRequest.getLanguages())
                .candidateId(createCandidateProfileRequest.getCandidateId())
                .createdAt(createCandidateProfileRequest.getCreatedAt())
                .build();
        CandidateProfileDto responseCandidateProfileDto = candidateProfileDao.createCandidateProfile(candidateProfileDto);
        CandidateProfileResponse candidateProfileResponse = CandidateProfileResponse.builder()
                .id(responseCandidateProfileDto.getId())
                .name(responseCandidateProfileDto.getName())
                .qualification(responseCandidateProfileDto.getQualification())
                .totalYoe(responseCandidateProfileDto.getTotalYoe())
                .languages(responseCandidateProfileDto.getLanguages())
                .candidateId(responseCandidateProfileDto.getCandidateId())
                .createdAt(responseCandidateProfileDto.getCreatedAt())
                .build();
        return candidateProfileResponse;
    }

    @Override
    public CandidateProfileResponse getCandidateProfileById(Long id) throws BadRequestException {
        CandidateProfileDto candidateProfileDto = candidateProfileDao.getCandidateProfileById(id);
        CandidateProfileResponse candidateProfileResponse = CandidateProfileResponse.builder()
                .id(candidateProfileDto.getId())
                .name(candidateProfileDto.getName())
                .qualification(candidateProfileDto.getQualification())
                .totalYoe(candidateProfileDto.getTotalYoe())
                .languages(candidateProfileDto.getLanguages())
                .candidateId(candidateProfileDto.getCandidateId())
                .createdAt(candidateProfileDto.getCreatedAt())
                .build();
        return candidateProfileResponse;
    }

    @Override
    public CandidateProfileResponse updateCandidateProfile(UpdateCandidateProfileRequest updateCandidateProfileRequest) {
        CandidateProfileDto candidateProfileDto = CandidateProfileDto.builder()
                .id(updateCandidateProfileRequest.getCandidateId())
                .name(updateCandidateProfileRequest.getName())
                .qualification(updateCandidateProfileRequest.getQualification())
                .totalYoe(updateCandidateProfileRequest.getTotalYoe())
                .languages(updateCandidateProfileRequest.getLanguages())
                .candidateId(updateCandidateProfileRequest.getCandidateId())
                .createdAt(updateCandidateProfileRequest.getCreatedAt())
                .build();
        CandidateProfileResponse candidateProfileResponse = candidateProfileDao.updateCandidateProfile(candidateProfileDto);
        return null;
    }

    @Override
    public Long deleteCandidateProfile(Long id) throws BadRequestException {
        CandidateProfileResponse candidateProfileResponse = this.getCandidateProfileById(id);
        CandidateProfileDto candidateProfileDto = CandidateProfileDto.builder()
                .id(candidateProfileResponse.getCandidateId())
                .name(candidateProfileResponse.getName())
                .qualification(candidateProfileResponse.getQualification())
                .totalYoe(candidateProfileResponse.getTotalYoe())
                .languages(candidateProfileResponse.getLanguages())
                .candidateId(candidateProfileResponse.getCandidateId())
                .createdAt(candidateProfileResponse.getCreatedAt())
                .build();

        CandidateProfileDto deletedCandidateProfileDto = candidateProfileDao.deleteCandidateProfile(candidateProfileDto);

        return deletedCandidateProfileDto.getId();
    }
}
