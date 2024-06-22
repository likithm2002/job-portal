package com.crud.jobportal.module.admin.dao.impl;

import com.crud.jobportal.module.admin.dao.AdminDao;
import com.crud.jobportal.module.admin.dto.AdminDto;
import com.crud.jobportal.module.admin.entity.Admin;

import com.crud.jobportal.module.admin.entity.QAdmin;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class AdminDaoImpl implements AdminDao {

    @PersistenceContext
    private EntityManager entityManager;

    QAdmin qAdmin = QAdmin.admin;

    @Override
    @Transactional
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .id(adminDto.getId())
                .name(adminDto.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();

        entityManager.persist(admin);

        AdminDto responseAdminDto = AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phoneNumber(admin.getPhoneNumber())
                .createdAt(admin.getCreatedAt())
                .build();

        return responseAdminDto;
    }

    @Override
    public AdminDto getAdminById(Long id) throws BadRequestException {
        Admin admin = entityManager.find(Admin.class, id);
        if (Objects.isNull(admin)) {
            throw new BadRequestException();
        }
        AdminDto adminDto = AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phoneNumber(admin.getPhoneNumber())
                .createdAt(admin.getCreatedAt())
                .build();
        return adminDto;
    }

    @Override
    @Transactional
    public AdminDto updateAdmin(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .id(adminDto.getId())
                .name(adminDto.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();
        Admin updatedAdmin = entityManager.merge(admin);

        AdminDto updatedAdminDto = AdminDto.builder()
                .id(updatedAdmin.getId())
                .name(updatedAdmin.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();
        return updatedAdminDto;
    }

    @Override
    public AdminDto deletedAdmin(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .id(adminDto.getId())
                .name(adminDto.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();

        entityManager.remove(entityManager.contains(admin) ? admin : entityManager.merge(admin));

        AdminDto responseAdminDto = AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phoneNumber(admin.getPhoneNumber())
                .createdAt(admin.getCreatedAt())
                .build();
        return responseAdminDto;
    }

    @Override
    public List<AdminDto> getAdmins() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<Admin> adminList = queryFactory.selectFrom(qAdmin)
                .fetch();

        List<AdminDto> adminDtoList = new ArrayList<>();
        for (Admin admin : adminList) {
            AdminDto adminDto = AdminDto.builder()
                    .id(admin.getId())
                    .name(admin.getName())
                    .email(admin.getEmail())
                    .phoneNumber(admin.getPhoneNumber())
                    .createdAt(new Date())
                    .build();
            adminDtoList.add(adminDto);
        }

        return adminDtoList;
    }
}
