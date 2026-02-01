package com.guvi.spring_boot_intro.repo;

import com.guvi.spring_boot_intro.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository {
    // TODO
    // save(Student student) -> save a student object
    void save(Student student);
    // findById(UUID id) -> will return a student matching an ID
    Optional<Student> findById(UUID id);
    // findAll() -> find and return ALL students
    List<Student> findAll();

}
