package com.crud.jobportal.module.admin.controller;

import com.crud.jobportal.module.admin.service.AdminService;
import com.crud.jobportal.module.admin.vo.request.CreateAdminRequest;
import com.crud.jobportal.module.admin.vo.request.UpdateAdminRequest;
import com.crud.jobportal.module.admin.vo.response.AdminResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody CreateAdminRequest createAdminRequest) {
        AdminResponse adminResponse = adminService.createAdmin(createAdminRequest);
        return ResponseEntity.ok().body(adminResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable Long id) throws BadRequestException {
        AdminResponse adminResponse = adminService.getAdminById(id);
        return ResponseEntity.ok().body(adminResponse);
    }

    @PutMapping
    public ResponseEntity<AdminResponse> updateAdmin(@RequestBody UpdateAdminRequest updateAdminRequest) {
        AdminResponse adminResponse = adminService.updateAdmin(updateAdminRequest);
        return new ResponseEntity<>(adminResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteAdmin(@PathVariable Long id) throws BadRequestException {
        Long deletedId = adminService.deleteAdmin(id);
        return ResponseEntity.ok().body(deletedId);
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> getAdmins() {
        List<AdminResponse> adminResponseList = adminService.getAdmins();
        return ResponseEntity.ok().body(adminResponseList);
    }
}











