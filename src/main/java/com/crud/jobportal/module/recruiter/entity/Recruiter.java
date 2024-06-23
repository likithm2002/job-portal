package com.crud.jobportal.module.recruiter.entity;

import com.crud.jobportal.module.admin.entity.Admin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recruiters")
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
