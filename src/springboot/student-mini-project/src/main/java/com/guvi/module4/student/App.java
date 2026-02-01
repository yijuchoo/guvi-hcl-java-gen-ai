package com.guvi.module4.student;

import com.guvi.module4.student.notify.ConsoleNotifier;
import com.guvi.module4.student.notify.Notifier;
import com.guvi.module4.student.repo.InMemoryStudentRepository;
import com.guvi.module4.student.repo.StudentRepository;
import com.guvi.module4.student.service.AttendanceService;
import com.guvi.module4.student.service.StudentService;

import java.time.LocalDate;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        // TODO:
        // 1) Create repo
        // Manage data -> talk to a database
        StudentRepository repo = new InMemoryStudentRepository();

        // 2) Create notifier
        Notifier notifier = new ConsoleNotifier();

        // 3) Create studentService with constructor injection
        // Write logic
        StudentService studentService = new StudentService(repo, notifier);

        // 4) Create attendanceService with constructor injection
        AttendanceService attendanceService = new AttendanceService(repo, notifier);

        // 5) Register a student
        UUID id = studentService.registerStudent("Ashik", "ashik@gmail.com");
        UUID id1 = studentService.registerStudent("Soumyajit", "soumyajit@gmail.com");

        // 6) Mark present
        attendanceService.markPresent(id, LocalDate.now());
        attendanceService.markPresent(id1, LocalDate.now());

        // 7) Print list of students
        System.out.println(studentService.listStudents());

        // This is the "wiring" place in plain Java.
        // Later, Spring will do this wiring for you.

        /*
        Output:
        [NOTIFICATION] ashik@gmail.com | Welcome Ashik, your data stored successfully.
        [NOTIFICATION] soumyajit@gmail.com | Welcome Soumyajit, your data stored successfully.
        [NOTIFICATION] ashik@gmail.com | Marked present on 2026-01-16
        [NOTIFICATION] soumyajit@gmail.com | Marked present on 2026-01-16
        [Student{id=d0c8745d-a1dd-4673-9837-843d945c68ea, name='Ashik', email='ashik@gmail.com'},
        Student{id=1c7e1376-b160-4731-9926-425426b28337, name='Soumyajit', email='soumyajit@gmail.com'}]
        */
    }
}
