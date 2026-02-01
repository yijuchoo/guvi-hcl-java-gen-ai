package com.guvi.module4.student.repo;

import com.guvi.module4.student.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository {
    // TODO
    // save(Student student) -> save a student object
    void save(Student student);
    // findById(UUID id) -> will return a student matching an ID
    Optional<Student> findById(UUID id);
    // findAll() -> find and return ALL students
    List<Student> findAll();

}
