package com.guvi.spring_boot_intro.repo;

import com.guvi.spring_boot_intro.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findByCodeIgnoreCase(String code);
}
