package com.crud.jobportal.module.admin.service.impl;

import com.crud.jobportal.module.admin.dao.AdminDao;
import com.crud.jobportal.module.admin.dto.AdminDto;
import com.crud.jobportal.module.admin.service.AdminService;
import com.crud.jobportal.module.admin.vo.request.CreateAdminRequest;
import com.crud.jobportal.module.admin.vo.request.UpdateAdminRequest;
import com.crud.jobportal.module.admin.vo.response.AdminResponse;
import com.crud.jobportal.module.candidate.dao.CandidateDao;
import com.crud.jobportal.module.candidate.dto.CandidateDto;
import com.crud.jobportal.module.candidate.vo.response.CandidateResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private CandidateDao candidateDao;


    @Override
    @Transactional
    public AdminResponse createAdmin(CreateAdminRequest createAdminRequest) {
        AdminDto adminDto = AdminDto.builder()
                .name(createAdminRequest.getName())
                .email(createAdminRequest.getEmail())
                .phoneNumber(createAdminRequest.getPhoneNumber())
                .createdAt(new Date())
                .build();

        AdminDto responseAdminDto = adminDao.createAdmin(adminDto);

        AdminResponse adminResponse = AdminResponse.builder()
                .id(responseAdminDto.getId())
                .name(responseAdminDto.getName())
                .email(responseAdminDto.getEmail())
                .phoneNumber(responseAdminDto.getPhoneNumber())
                .createdAt(responseAdminDto.getCreatedAt())
                .build();

        return adminResponse;
    }

    @Override
    public AdminResponse getAdminById(Long id) throws BadRequestException {
        AdminDto adminDto = adminDao.getAdminById(id);
        AdminResponse adminResponse = AdminResponse.builder()
                .id(adminDto.getId())
                .name(adminDto.getName())
                .email(adminDto.getEmail())
                .phoneNumber(adminDto.getPhoneNumber())
                .createdAt(adminDto.getCreatedAt())
                .build();
        return adminResponse;
    }

    @Override
    @Transactional
    public AdminResponse updateAdmin(UpdateAdminRequest updateAdminRequest) {
        AdminDto adminDto = AdminDto.builder()
                .id(updateAdminRequest.getId())
                .name(updateAdminRequest.getName())
                .email(updateAdminRequest.getEmail())
                .phoneNumber(updateAdminRequest.getPhoneNumber())
                .createdAt(updateAdminRequest.getCreatedAt())
                .build();

        AdminDto responseAdminDto = adminDao.updateAdmin(adminDto);

        AdminResponse adminResponse = AdminResponse.builder()
                .id(responseAdminDto.getId())
                .name(responseAdminDto.getName())
                .email(responseAdminDto.getEmail())
                .phoneNumber(responseAdminDto.getPhoneNumber())
                .createdAt(responseAdminDto.getCreatedAt())
                .build();

        return adminResponse;
    }

    @Override
    @Transactional
    public Long deleteAdmin(Long id) throws BadRequestException {
        AdminResponse adminResponse = this.getAdminById(id);
        AdminDto adminDto = AdminDto.builder()
                .id(adminResponse.getId())
                .name(adminResponse.getName())
                .email(adminResponse.getEmail())
                .phoneNumber(adminResponse.getPhoneNumber())
                .createdAt(adminResponse.getCreatedAt())
                .build();
        AdminDto deletedAdminDto = adminDao.deletedAdmin(adminDto);
        return deletedAdminDto.getId();
    }

    @Override
    public List<AdminResponse> getAdmins() {
        List<AdminDto> adminDtoList = adminDao.getAdmins();
        List<AdminResponse> adminResponseList = new ArrayList<>();

        for (AdminDto adminDto : adminDtoList) {
            AdminResponse adminResponse = AdminResponse.builder()
                    .id(adminDto.getId())
                    .name(adminDto.getName())
                    .email(adminDto.getEmail())
                    .phoneNumber(adminDto.getPhoneNumber())
                    .createdAt(new Date())
                    .build();
            adminResponseList.add(adminResponse);
        }

        return adminResponseList;
    }

    @Override
    public List<CandidateResponse> getAllCandidates() {
        List<CandidateDto> candidateDtoList = candidateDao.getAllCandidates();
        List<CandidateResponse> candidateResponseList = new ArrayList<>();

        for (CandidateDto candidateDto : candidateDtoList) {
            CandidateResponse candidateResponse = CandidateResponse.builder()
                    .id(candidateDto.getId())
                    .name(candidateDto.getName())
                    .email(candidateDto.getEmail())
                    .age(candidateDto.getAge())
                    .gender(candidateDto.getGender())
                    .phoneNumber(candidateDto.getPhoneNumber())
                    .cityName(candidateDto.getCityName())
                    .createdAt(candidateDto.getCreatedAt())
                    .build();
            candidateResponseList.add(candidateResponse);
        }
        return candidateResponseList;
    }
}
