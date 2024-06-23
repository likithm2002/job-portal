package com.crud.jobportal.module.admin.entity;

import com.crud.jobportal.module.candidate.entity.Candidate;
import com.crud.jobportal.module.recruiter.entity.Recruiter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date createdAt;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Candidate> candidateList = new ArrayList<>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Recruiter> recruiterList = new ArrayList<>();
}
