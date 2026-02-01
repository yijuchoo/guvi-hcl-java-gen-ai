package com.guvi.module4.student.repo;

import com.guvi.module4.student.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Soumyajit
public interface StudentRepository {
    void save(Student student);
    Optional<Student> findById(UUID id);
    List<Student> findAll();

    // TODO (Task: Find Student by Email)
    // 1) Add a method signature to find a student by email.
    //    - Method Name should be findByEmail
    //    - Return type should be Optional<Student>
    //    - Parameter should be String email
    Optional<Student> findByEmail(String email);
}