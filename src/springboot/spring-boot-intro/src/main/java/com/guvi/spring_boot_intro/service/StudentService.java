package com.guvi.spring_boot_intro.service;

import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.notify.Notifier;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    // TODO:
    // 1) Add fields: StudentRepository repo, Notifier notifier
    private final StudentRepository repo;
    private final Notifier notifier;

    // 2) Constructor injection: StudentService(StudentRepository repo, Notifier notifier)
    public StudentService(StudentRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public UUID registerStudent(String name, String email) {
        // TODO:
        // 1) Create UUID -> UUID id = UUID.randomUUID();
        UUID id = UUID.randomUUID();

        // 2) Create Student
        Student student = new Student(id, name, email);

        // 3) repo.save(student)
        repo.save(student);

        // 4) notifier.send(email, welcomeMessage)
        String welcomeMessage = "Welcome " + name + ", your data stored successfully.";

        // 5) return UUID
        notifier.send(email, welcomeMessage);

        return id;
    }

    public List<Student> listStudents() {
        // TODO: return ALL Students
        return repo.findAll();
    }
}
