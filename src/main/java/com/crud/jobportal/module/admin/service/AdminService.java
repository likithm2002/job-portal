package com.crud.jobportal.module.admin.service;

import com.crud.jobportal.module.admin.vo.request.CreateAdminRequest;
import com.crud.jobportal.module.admin.vo.request.UpdateAdminRequest;
import com.crud.jobportal.module.admin.vo.response.AdminResponse;
import com.crud.jobportal.module.candidate.vo.response.CandidateResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface AdminService{

    AdminResponse createAdmin(CreateAdminRequest createAdminRequest);

    AdminResponse getAdminById(Long id) throws BadRequestException;

    AdminResponse updateAdmin(UpdateAdminRequest updateAdminRequest);

    Long deleteAdmin(Long id) throws BadRequestException;

    List<AdminResponse> getAdmins();

    List<CandidateResponse> getAllCandidates();
}
