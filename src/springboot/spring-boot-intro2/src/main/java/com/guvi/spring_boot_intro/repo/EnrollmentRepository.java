package com.guvi.spring_boot_intro.repo;

import com.guvi.spring_boot_intro.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
}
