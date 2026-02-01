package com.guvi.module4.student.main;

import com.guvi.module4.student.service.AttendanceService;
import com.guvi.module4.student.service.StudentService;
import com.guvi.module4.tinyframework.container.StartupTask;

import java.time.LocalDate;
import java.util.UUID;

/**
 * A container-managed startup task.
 *
 * This is where the framework calls your code AFTER all dependencies are ready.
 */
public class DemoStartup implements StartupTask {

    private final StudentService studentService;
    private final AttendanceService attendanceService;

    public DemoStartup(StudentService studentService, AttendanceService attendanceService) {
        this.studentService = studentService;
        this.attendanceService = attendanceService;
    }

    @Override
    public void run() {
        UUID id = studentService.registerStudent("Ashik", "ashik@gmail.com");
        attendanceService.markPresent(id, LocalDate.now());

        System.out.println("Students: " + studentService.listStudents());

        // TODO (Feature request): add findByEmail end-to-end and then call it here.
        // Example:
         System.out.println("Find by email: " + studentService.getStudentByEmail("ashik@gmail.com"));
    }
}
