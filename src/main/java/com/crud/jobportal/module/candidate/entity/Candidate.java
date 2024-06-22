package com.crud.jobportal.module.candidate.entity;

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
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String phoneNumber;
    private String cityName;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
