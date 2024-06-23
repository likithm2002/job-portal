package com.crud.jobportal.module.candidate.service.impl;

import com.crud.jobportal.module.candidate.dao.CandidateDao;
import com.crud.jobportal.module.candidate.dto.CandidateDto;
import com.crud.jobportal.module.candidate.service.CandidateService;
import com.crud.jobportal.module.candidate.vo.request.CreateCandidateRequest;
import com.crud.jobportal.module.candidate.vo.request.UpdateCandidateRequest;
import com.crud.jobportal.module.candidate.vo.response.CandidateResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDao candidateDao;

    @Override
    @Transactional
    public CandidateResponse createCandidate(CreateCandidateRequest createCandidateRequest) throws BadRequestException {
        CandidateDto candidateDto = CandidateDto.builder()
                .name(createCandidateRequest.getName())
                .age(createCandidateRequest.getAge())
                .gender(createCandidateRequest.getGender())
                .email(createCandidateRequest.getEmail())
                .phoneNumber(createCandidateRequest.getPhoneNumber())
                .cityName(createCandidateRequest.getCityName())
                .createdAt(new Date())
                .adminId(createCandidateRequest.getAdminId())
                .build();

        CandidateDto responseCandidateDto = candidateDao.createCandidate(candidateDto);

        CandidateResponse candidateResponse = CandidateResponse.builder()
                .id(responseCandidateDto.getId())
                .name(responseCandidateDto.getName())
                .age(responseCandidateDto.getAge())
                .gender(responseCandidateDto.getGender())
                .email(responseCandidateDto.getEmail())
                .phoneNumber(responseCandidateDto.getPhoneNumber())
                .cityName(responseCandidateDto.getCityName())
                .createdAt(responseCandidateDto.getCreatedAt())
                .build();

        return candidateResponse;
    }

    @Override
    public CandidateResponse getCandidateById(Long id) throws BadRequestException {
        CandidateDto candidateDto = candidateDao.getAdminById(id);
        CandidateResponse candidateResponse = CandidateResponse.builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .age(candidateDto.getAge())
                .email(candidateDto.getEmail())
                .gender(candidateDto.getGender())
                .phoneNumber(candidateDto.getPhoneNumber())
                .createdAt(candidateDto.getCreatedAt())
                .cityName(candidateDto.getCityName())
                .build();
        return candidateResponse;
    }

    @Override
    @Transactional
    public CandidateResponse updateCandidate(UpdateCandidateRequest updateCandidateRequest) {
        CandidateDto candidateDto = CandidateDto.builder()
                .id(updateCandidateRequest.getId())
                .name(updateCandidateRequest.getName())
                .age(updateCandidateRequest.getAge())
                .email(updateCandidateRequest.getEmail())
                .gender(updateCandidateRequest.getGender())
                .phoneNumber(updateCandidateRequest.getPhoneNumber())
                .createdAt(updateCandidateRequest.getCreatedAt())
                .cityName(updateCandidateRequest.getCityName())
                .build();
        CandidateDto responseCandidateDto = candidateDao.updateCandidate(candidateDto);

        CandidateResponse candidateResponse = CandidateResponse.builder()
                .id(responseCandidateDto.getId())
                .name(responseCandidateDto.getName())
                .age(responseCandidateDto.getAge())
                .email(responseCandidateDto.getEmail())
                .gender(responseCandidateDto.getGender())
                .phoneNumber(responseCandidateDto.getPhoneNumber())
                .createdAt(responseCandidateDto.getCreatedAt())
                .cityName(responseCandidateDto.getCityName())
                .build();

        return candidateResponse;
    }

    @Override
    @Transactional
    public Long deleteCandidate(Long id) throws BadRequestException {
        CandidateResponse candidateResponse = this.getCandidateById(id);
        CandidateDto candidateDto = CandidateDto.builder()
                .id(candidateResponse.getId())
                .name(candidateResponse.getName())
                .age(candidateResponse.getAge())
                .email(candidateResponse.getEmail())
                .gender(candidateResponse.getGender())
                .phoneNumber(candidateResponse.getPhoneNumber())
                .cityName(candidateResponse.getCityName())
                .createdAt(candidateResponse.getCreatedAt())
                .build();
        CandidateDto deleteCandidateDto = candidateDao.deleteCandidate(candidateDto);

        return deleteCandidateDto.getId();
    }

    @Override
    public List<CandidateResponse> getCandidates() {
        List<CandidateDto> candidateDtoList = candidateDao.getCandidates();
        List<CandidateResponse> candidateResponseList = new ArrayList<>();

        for (CandidateDto  candidateDto : candidateDtoList) {
            CandidateResponse candidateResponse = CandidateResponse.builder()
                    .id(candidateDto.getId())
                    .name(candidateDto.getName())
                    .age(candidateDto.getAge())
                    .email(candidateDto.getEmail())
                    .gender(candidateDto.getGender())
                    .phoneNumber(candidateDto.getPhoneNumber())
                    .cityName(candidateDto.getCityName())
                    .createdAt(new Date())
                    .build();
            candidateResponseList.add(candidateResponse);
         }
        return candidateResponseList;
    }
}


