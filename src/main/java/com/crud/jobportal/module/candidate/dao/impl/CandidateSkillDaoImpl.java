package com.crud.jobportal.module.candidate.dao.impl;

import com.crud.jobportal.module.candidate.dao.CandidateSkillDao;
import com.crud.jobportal.module.candidate.dto.CandidateSkillDto;
import com.crud.jobportal.module.candidate.entity.CandidateSkill;
import com.crud.jobportal.module.candidate.entity.QCandidateSkill;
import com.crud.jobportal.module.recruiter.vo.request.CandidateShortlistRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.crud.jobportal.module.candidate.entity.QCandidateSkill.candidateSkill;

@Repository
public class CandidateSkillDaoImpl implements CandidateSkillDao {


    @Autowired
    private EntityManager entityManager;

    QCandidateSkill qCandidateSkill = candidateSkill;

    @Override
    @Transactional
    public CandidateSkillDto createCandidateSkill(CandidateSkillDto candidateSkillDto) {
        CandidateSkill candidateSkill = CandidateSkill.builder()
                .id(candidateSkillDto.getId())
                .skill(candidateSkillDto.getSkill())
                .yoe(candidateSkillDto.getYoe())
                .candidateId(candidateSkillDto.getCandidateId())
                .createdAt(new Date())
                .createdBy(candidateSkillDto.getCreatedBy())
                .build();
        entityManager.persist(candidateSkill);

        CandidateSkillDto responseCandidateSkillDto = CandidateSkillDto.builder()
                .id(candidateSkill.getId())
                .skill(candidateSkill.getSkill())
                .yoe(candidateSkill.getYoe())
                .candidateId(candidateSkill.getCandidateId())
                .createdBy(candidateSkill.getCreatedBy())
                .createdAt(candidateSkill.getCreatedAt())
                .build();

        return responseCandidateSkillDto;
    }

    @Override
    public CandidateSkillDto getCandidateSkillById(Long id) {
        CandidateSkill candidateSkill = entityManager.find(CandidateSkill.class, id);
        CandidateSkillDto candidateSkillDto = CandidateSkillDto.builder()
                .id(candidateSkill.getId())
                .skill(candidateSkill.getSkill())
                .yoe(candidateSkill.getYoe())
                .candidateId(candidateSkill.getCandidateId())
                .createdAt(candidateSkill.getCreatedAt())
                .createdBy(candidateSkill.getCreatedBy())
                .build();
        return candidateSkillDto;
    }

    @Override
    public List<CandidateSkillDto> getShortlistedCandidates(CandidateShortlistRequest candidateShortlistRequest) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<CandidateSkill> candidateSkillList = queryFactory.selectFrom(qCandidateSkill)
                .where(qCandidateSkill.skill.eq(candidateShortlistRequest.getSkill())
                        .and(qCandidateSkill.yoe.goe(candidateShortlistRequest.getMinimumYearsOfExperience())))
                .fetch();

        List<CandidateSkillDto> candidateSkillDtoList = new ArrayList<>();
        for (CandidateSkill candidateSkill : candidateSkillList) {
            CandidateSkillDto candidateSkillDto = CandidateSkillDto.builder()
                    .id(candidateSkill.getId())
                    .skill(candidateSkill.getSkill())
                    .yoe(candidateSkill.getYoe())
                    .candidateId(candidateSkill.getCandidateId())
                    .createdAt(candidateSkill.getCreatedAt())
                    .createdBy(candidateSkill.getCreatedBy())
                    .build();
            candidateSkillDtoList.add(candidateSkillDto);
        }
        return candidateSkillDtoList;
    }


    @Override
    @Transactional
    public CandidateSkillDto deleteCandidateSkill(CandidateSkillDto candidateSkillDto) {
        CandidateSkill candidateSkill = CandidateSkill.builder()
                .id(candidateSkillDto.getId())
                .skill(candidateSkillDto.getSkill())
                .yoe(candidateSkillDto.getYoe())
                .candidateId(candidateSkillDto.getCandidateId())
                .createdAt(candidateSkillDto.getCreatedAt())
                .createdBy(candidateSkillDto.getCreatedBy())
                .build();
        entityManager.remove(entityManager.contains(candidateSkill) ? candidateSkill : entityManager.merge(candidateSkill));

        CandidateSkillDto resposneCandidateSkillDto = CandidateSkillDto.builder()
                .id(candidateSkill.getId())
                .skill(candidateSkill.getSkill())
                .yoe(candidateSkill.getYoe())
                .candidateId(candidateSkill.getCandidateId())
                .createdAt(candidateSkill.getCreatedAt())
                .createdBy(candidateSkill.getCreatedBy())
                .build();
        return resposneCandidateSkillDto;
    }
}
