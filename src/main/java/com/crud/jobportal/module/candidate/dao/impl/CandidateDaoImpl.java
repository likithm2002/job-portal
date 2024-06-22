package com.crud.jobportal.module.candidate.dao.impl;

import com.crud.jobportal.module.admin.dao.AdminDao;
import com.crud.jobportal.module.admin.dto.AdminDto;
import com.crud.jobportal.module.admin.entity.Admin;
import com.crud.jobportal.module.candidate.dao.CandidateDao;
import com.crud.jobportal.module.candidate.dto.CandidateDto;
import com.crud.jobportal.module.candidate.entity.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Repository
public class CandidateDaoImpl implements CandidateDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional
    public CandidateDto createCandidate(CandidateDto candidateDto) throws BadRequestException {

        AdminDto adminDto = adminDao.getAdminById(candidateDto.getAdminId());
        Admin admin = Admin.builder()
                .id(adminDto.getId())
                .name(adminDto.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();

        Candidate candidate = Candidate.builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .age(candidateDto.getAge())
                .email(candidateDto.getEmail())
                .phoneNumber(candidateDto.getPhoneNumber())
                .cityName(candidateDto.getCityName())
                .gender(candidateDto.getGender())
                .createdAt(candidateDto.getCreatedAt())
                .admin(admin)
                .build();
        entityManager.persist(candidate);

        CandidateDto responseCandidateDto = CandidateDto.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .age(candidate.getAge())
                .email(candidate.getEmail())
                .gender(candidate.getGender())
                .phoneNumber(candidate.getPhoneNumber())
                .createdAt(candidateDto.getCreatedAt())
                .cityName(candidate.getCityName())
                .adminId(candidate.getAdmin().getId())
                .build();

        return responseCandidateDto;
    }

    @Override
    public CandidateDto getAdminById(Long id) throws BadRequestException {
        Candidate candidate = entityManager.find(Candidate.class, id);
        if (Objects.isNull(candidate)) {
            throw new BadRequestException();
        }
        CandidateDto candidateDto = CandidateDto.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .age(candidate.getAge())
                .email(candidate.getEmail())
                .gender(candidate.getGender())
                .phoneNumber(candidate.getPhoneNumber())
                .createdAt(candidate.getCreatedAt())
                .cityName(candidate.getCityName())
                .build();
        return candidateDto;
    }

    @Override
    @Transactional
    public CandidateDto updateCandidate(CandidateDto candidateDto) {
        Candidate candidate = Candidate.builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .age(candidateDto.getAge())
                .email(candidateDto.getEmail())
                .gender(candidateDto.getGender())
                .phoneNumber(candidateDto.getPhoneNumber())
                .createdAt(candidateDto.getCreatedAt())
                .cityName(candidateDto.getCityName())
                .build();

        Candidate updatedCandidate = entityManager.merge(candidate);

        CandidateDto updatedCandidateDto = CandidateDto.builder()
                .id(updatedCandidate.getId())
                .name(updatedCandidate.getName())
                .age(updatedCandidate.getAge())
                .email(updatedCandidate.getEmail())
                .gender(updatedCandidate.getGender())
                .phoneNumber(updatedCandidate.getPhoneNumber())
                .createdAt(updatedCandidate.getCreatedAt())
                .cityName(updatedCandidate.getCityName())
                .build();

        return updatedCandidateDto;
    }

    @Override
    public CandidateDto deleteCandidate(CandidateDto candidateDto) {
        Candidate candidate = Candidate.builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .age(candidateDto.getAge())
                .email(candidateDto.getEmail())
                .gender(candidateDto.getGender())
                .phoneNumber(candidateDto.getPhoneNumber())
                .createdAt(candidateDto.getCreatedAt())
                .cityName(candidateDto.getCityName())
                .build();
        entityManager.remove(entityManager.contains(candidate) ? candidate : entityManager.merge(candidate));

        CandidateDto responseCandidateDto = CandidateDto.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .age(candidate.getAge())
                .email(candidate.getEmail())
                .gender(candidate.getGender())
                .phoneNumber(candidate.getPhoneNumber())
                .createdAt(candidate.getCreatedAt())
                .cityName(candidate.getCityName())
                .build();
        // Dummy comment
        return responseCandidateDto;
    }
}
