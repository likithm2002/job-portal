package com.crud.jobportal.module.candidateprofile.dao.impl;

import com.crud.jobportal.module.candidateprofile.dao.CandidateProfileDao;
import com.crud.jobportal.module.candidateprofile.dto.CandidateProfileDto;
import com.crud.jobportal.module.candidateprofile.entity.CandidateProfile;
import com.crud.jobportal.module.candidateprofile.vo.response.CandidateProfileResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.BadRequestException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

public class CandidateProfileDaoImpl implements CandidateProfileDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public CandidateProfileDto createCandidateProfile(CandidateProfileDto candidateProfileDto) {
        CandidateProfile candidateProfile = CandidateProfile.builder()
                .id(candidateProfileDto.getId())
                .name(candidateProfileDto.getName())
                .qualification(candidateProfileDto.getQualification())
                .totalYoe(candidateProfileDto.getTotalYoe())
                .languages(candidateProfileDto.getLanguages())
                .candidateId(candidateProfileDto.getCandidateId())
                .createdAt(new Date())
                .build();

        entityManager.persist(candidateProfile);

        CandidateProfileDto responseCandidateProfileDto = CandidateProfileDto.builder()
                .id(candidateProfile.getId())
                .name(candidateProfile.getName())
                .qualification(candidateProfile.getQualification())
                .totalYoe(candidateProfile.getTotalYoe())
                .languages(candidateProfile.getLanguages())
                .candidateId(candidateProfile.getCandidateId())
                .createdAt(candidateProfile.getCreatedAt())
                .build();

        return responseCandidateProfileDto;
    }

    @Override
    public CandidateProfileDto getCandidateProfileById(Long id) throws BadRequestException {
        CandidateProfile candidateProfile = entityManager.find(CandidateProfile.class, id);
        if (Objects.isNull(candidateProfile)) {
            throw new BadRequestException();
        }

        CandidateProfileDto candidateProfileDto = CandidateProfileDto.builder()
                .id(candidateProfile.getId())
                .name(candidateProfile.getName())
                .qualification(candidateProfile.getQualification())
                .totalYoe(candidateProfile.getTotalYoe())
                .languages(candidateProfile.getLanguages())
                .candidateId(candidateProfile.getCandidateId())
                .createdAt(candidateProfile.getCreatedAt())
                .build();

        return candidateProfileDto;
    }

    @Override
    public CandidateProfileResponse updateCandidateProfile(CandidateProfileDto candidateProfileDto) {
        CandidateProfile candidateProfile = CandidateProfile.builder()
                .id(candidateProfileDto.getId())
                .name(candidateProfileDto.getName())
                .qualification(candidateProfileDto.getQualification())
                .totalYoe(candidateProfileDto.getTotalYoe())
                .languages(candidateProfileDto.getLanguages())
                .candidateId(candidateProfileDto.getCandidateId())
                .createdAt(candidateProfileDto.getCreatedAt())
                .build();
        CandidateProfile updatedCandidateProfile = entityManager.merge(candidateProfile);

        CandidateProfileResponse candidateProfileResponse = CandidateProfileResponse.builder()
                .id(updatedCandidateProfile.getId())
                .name(updatedCandidateProfile.getName())
                .qualification(updatedCandidateProfile.getQualification())
                .totalYoe(updatedCandidateProfile.getTotalYoe())
                .languages(updatedCandidateProfile.getLanguages())
                .candidateId(updatedCandidateProfile.getCandidateId())
                .createdAt(updatedCandidateProfile.getCreatedAt())
                .build();

        return candidateProfileResponse;
    }

    @Override
    public CandidateProfileDto deleteCandidateProfile(CandidateProfileDto candidateProfileDto) {
        CandidateProfile candidateProfile = CandidateProfile.builder()
                .id(candidateProfileDto.getId())
                .name(candidateProfileDto.getName())
                .qualification(candidateProfileDto.getQualification())
                .totalYoe(candidateProfileDto.getTotalYoe())
                .languages(candidateProfileDto.getLanguages())
                .candidateId(candidateProfileDto.getCandidateId())
                .createdAt(candidateProfileDto.getCreatedAt())
                .build();
        entityManager.remove(entityManager.contains(candidateProfile) ?
                candidateProfile : entityManager.merge(candidateProfile));

        CandidateProfileDto responseCandidateProfileDto = CandidateProfileDto.builder()
                .id(candidateProfile.getId())
                .name(candidateProfile.getName())
                .qualification(candidateProfile.getQualification())
                .totalYoe(candidateProfile.getTotalYoe())
                .languages(candidateProfile.getLanguages())
                .candidateId(candidateProfile.getCandidateId())
                .createdAt(candidateProfile.getCreatedAt())
                .build();
        return responseCandidateProfileDto;
    }
}
