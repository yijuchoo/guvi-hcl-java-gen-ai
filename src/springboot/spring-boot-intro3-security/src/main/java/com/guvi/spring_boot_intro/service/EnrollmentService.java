package com.guvi.spring_boot_intro.service;

import com.guvi.spring_boot_intro.repo.EnrollmentRepository;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepo;

    public EnrollmentService(EnrollmentRepository enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }
}
