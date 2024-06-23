package com.crud.jobportal.module.recruiter.dao.impl;

import com.crud.jobportal.module.admin.dao.AdminDao;
import com.crud.jobportal.module.admin.dto.AdminDto;
import com.crud.jobportal.module.admin.entity.Admin;
import com.crud.jobportal.module.recruiter.dao.RecruiterDao;
import com.crud.jobportal.module.recruiter.dto.RecruiterDto;
import com.crud.jobportal.module.recruiter.entity.QRecruiter;
import com.crud.jobportal.module.recruiter.entity.Recruiter;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class RecruiterDaoImpl implements RecruiterDao {

    QRecruiter qRecruiter = QRecruiter.recruiter;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional
    public RecruiterDto createRecruiter(RecruiterDto recruiterDto) throws BadRequestException {
        AdminDto adminDto = adminDao.getAdminById(recruiterDto.getAdminId());
        Admin admin = Admin.builder()
                .id(adminDto.getId())
                .name(adminDto.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();

        Recruiter recruiter = Recruiter.builder()
                .id(recruiterDto.getId())
                .name(recruiterDto.getName())
                .email(recruiterDto.getEmail())
                .companyName(recruiterDto.getCompanyName())
                .phoneNumber(recruiterDto.getPhoneNumber())
                .createdAt(new Date())
                .admin(admin)
                .build();

        entityManager.persist(recruiter);

        RecruiterDto responseRecruiterDto = RecruiterDto.builder()
                .id(recruiter.getId())
                .name(recruiter.getCompanyName())
                .email(recruiter.getEmail())
                .companyName(recruiter.getCompanyName())
                .phoneNumber(recruiter.getPhoneNumber())
                .createdAt(new Date())
                .adminId(recruiter.getAdmin().getId())
                .build();
        return responseRecruiterDto;
    }

    @Override
    public RecruiterDto getRecruiterById(Long id) throws BadRequestException {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Recruiter recruiter = queryFactory.selectFrom(qRecruiter)
                .where(qRecruiter.id.eq(id))
                .fetchOne();
        if (Objects.isNull(recruiter)) {
            throw new BadRequestException();
        }

        RecruiterDto recruiterDto = RecruiterDto.builder()
                .id(recruiter.getId())
                .name(recruiter.getCompanyName())
                .email(recruiter.getEmail())
                .companyName(recruiter.getCompanyName())
                .phoneNumber(recruiter.getPhoneNumber())
                .createdAt(new Date())
                .build();
        return recruiterDto;
    }

    @Override
    @Transactional
    public RecruiterDto updateRecruiter(RecruiterDto recruiterDto) {
        Recruiter recruiter = Recruiter.builder()
                .id(recruiterDto.getId())
                .name(recruiterDto.getName())
                .email(recruiterDto.getEmail())
                .companyName(recruiterDto.getCompanyName())
                .phoneNumber(recruiterDto.getPhoneNumber())
                .createdAt(new Date())
                .build();
        Recruiter updatedRecruiter = entityManager.merge(recruiter);

        RecruiterDto updatedRecruiterDto = RecruiterDto.builder()
                .id(updatedRecruiter.getId())
                .name(updatedRecruiter.getName())
                .email(updatedRecruiter.getEmail())
                .companyName(updatedRecruiter.getCompanyName())
                .phoneNumber(updatedRecruiter.getPhoneNumber())
                .createdAt(new Date())
                .build();
        return updatedRecruiterDto;
    }

    @Override
    @Transactional
    public RecruiterDto deleteRecruiter(RecruiterDto recruiterDto) {
        Recruiter recruiter = Recruiter.builder()
                .id(recruiterDto.getId())
                .name(recruiterDto.getName())
                .email(recruiterDto.getEmail())
                .companyName(recruiterDto.getCompanyName())
                .phoneNumber(recruiterDto.getPhoneNumber())
                .createdAt(recruiterDto.getCreatedAt())
                .build();
        entityManager.remove(entityManager.contains(recruiter) ? recruiter : entityManager.merge(recruiter));

        RecruiterDto responseRecruiterDto = RecruiterDto.builder()
                .id(recruiter.getId())
                .name(recruiter.getCompanyName())
                .email(recruiter.getEmail())
                .companyName(recruiter.getCompanyName())
                .phoneNumber(recruiter.getPhoneNumber())
                .createdAt(recruiter.getCreatedAt())
                .build();
        return responseRecruiterDto;
    }

    @Override
    public List<RecruiterDto> getRecruiters() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<Recruiter> recruiterList = queryFactory.selectFrom(qRecruiter)
                .fetch();
        List<RecruiterDto> recruiterDtoList =  new ArrayList<>();
        for (Recruiter recruiter : recruiterList) {
            RecruiterDto recruiterDto = RecruiterDto.builder()
                    .id(recruiter.getId())
                    .name(recruiter.getCompanyName())
                    .email(recruiter.getEmail())
                    .companyName(recruiter.getCompanyName())
                    .phoneNumber(recruiter.getPhoneNumber())
                    .createdAt(new Date())
                    .build();
            recruiterDtoList.add(recruiterDto);
        }
        return recruiterDtoList;
    }
}
