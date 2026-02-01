package com.guvi.module4.student.service;

import com.guvi.module4.student.model.Student;
import com.guvi.module4.student.notify.Notifier;
import com.guvi.module4.student.repo.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Thirumani
public class StudentService {

    private final StudentRepository repo;
    private final Notifier notifier;

    public StudentService(StudentRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public UUID registerStudent(String name, String email) {
        UUID id = UUID.randomUUID();
        Student student = new Student(id, name, email);
        repo.save(student);

        String welcomeMessage = "Welcome " + name + " your data stored successfully.";
        notifier.send(email, welcomeMessage);

        return id;
    }

    public List<Student> listStudents() {
        return repo.findAll();
    }

    // TODO (Task: Find Student by Email)
    // 3) Add a service method that uses findByEmail(email) in repo
    //    Steps:
    //    1) Create method: Optional<Student> getStudentByEmail(String email)
    //    2) Call repo.findByEmail(email)
    //    3) Return the result (Optional<Student>)
    //
     public Optional<Student> getStudentByEmail(String email) {
         // TODO 3) Call repo.findByEmail(email)
         Optional<Student> student = repo.findByEmail(email);
         return Optional.empty();
     }
}

