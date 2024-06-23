package com.crud.jobportal.module.candidate.dao.impl;

import com.crud.jobportal.module.admin.dao.AdminDao;
import com.crud.jobportal.module.admin.dto.AdminDto;
import com.crud.jobportal.module.admin.entity.Admin;
import com.crud.jobportal.module.candidate.dao.CandidateDao;
import com.crud.jobportal.module.candidate.dto.CandidateDto;
import com.crud.jobportal.module.candidate.entity.Candidate;
import com.crud.jobportal.module.candidate.entity.QCandidate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository
public class CandidateDaoImpl implements CandidateDao {

    @PersistenceContext
    private EntityManager entityManager;

    QCandidate qCandidate = QCandidate.candidate;

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
    public CandidateDto getCandidateById(Long id) throws BadRequestException {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        // SELECT * FROM candidates WHERE id = :id;
        Candidate candidate = queryFactory.selectFrom(qCandidate)
                .where(qCandidate.id.eq(id))
                .fetchOne();

//        Candidate candidate = entityManager.find(Candidate.class, id);
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

    @Override
    public List<CandidateDto> getCandidates() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<Candidate> candidateList = queryFactory.selectFrom(qCandidate)
                .fetch();
        List<CandidateDto> candidateDtoList = new ArrayList<>();
         for (Candidate candidate : candidateList) {
             CandidateDto candidateDto = CandidateDto.builder()
                     .id(candidate.getId())
                     .name(candidate.getName())
                     .age(candidate.getAge())
                     .email(candidate.getEmail())
                     .gender(candidate.getGender())
                     .phoneNumber(candidate.getPhoneNumber())
                     .cityName(candidate.getCityName())
                     .createdAt(candidate.getCreatedAt())
                     .build();
             candidateDtoList.add(candidateDto);
         }
        return candidateDtoList;
    }
}
