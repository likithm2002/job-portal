package com.crud.jobportal.module.admin.dao;

import com.crud.jobportal.module.admin.dto.AdminDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface AdminDao {
    AdminDto createAdmin(AdminDto adminDto);

    AdminDto getAdminById(Long id) throws BadRequestException;

    AdminDto updateAdmin(AdminDto adminDto);

    AdminDto deletedAdmin(AdminDto adminDto);

    List<AdminDto> getAdmins();
}
