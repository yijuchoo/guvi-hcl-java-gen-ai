package com.guvi.module4.student.service;

import com.guvi.module4.student.model.Student;
import com.guvi.module4.student.notify.Notifier;
import com.guvi.module4.student.repo.StudentRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class AttendanceService {

    // TODO:
    // Add fields:
    // StudentRepository repo, Notifier notifier
    private final StudentRepository repo;
    private final Notifier notifier;

    // Constructor injection: AttendanceService(StudentRepository repo, Notifier notifier)
    public AttendanceService(StudentRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public void markPresent(UUID studentId, LocalDate date) {
        // TODO:
        // 1) Find student via repo.findById(studentId)
        // 2) If not found, throw IllegalArgumentException("Student not found: " + studentId)
        // 3) If found, notifier.send(student.getEmail(), attendanceMessage)

        // Example message:
        // "Marked present on 2026-01-16"
        Student student = repo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + studentId));
        String attendanceMessage = "Marked present on " + date;
        notifier.send(student.getEmail(), attendanceMessage);

    }
}
