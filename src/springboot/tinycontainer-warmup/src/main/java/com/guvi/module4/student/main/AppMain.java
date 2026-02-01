package com.guvi.module4.student.main;

import com.guvi.module4.student.notify.ConsoleNotifier;
import com.guvi.module4.student.repo.InMemoryStudentRepository;
import com.guvi.module4.student.service.AttendanceService;
import com.guvi.module4.student.service.StudentService;
import com.guvi.module4.tinyframework.diagnostics.ContainerReport;
import com.guvi.module4.tinyframework.container.TinyContainer;

/**
 * Entry point for the warmup.
 *
 * In plain Java, you'd write a lot of `new` here.
 * In a framework style, you register components and let the container do the object creation and wiring.
 */
public class AppMain {
    public static void main(String[] args) {
        // Creating an instance of a class, TinyContainer
        // Comparable to the "container" in Spring
        TinyContainer container = new TinyContainer();

        // Registration phase: tell the container what it should manage.
        container.register(InMemoryStudentRepository.class);
        container.register(ConsoleNotifier.class);
        container.register(StudentService.class);
        container.register(AttendanceService.class);

        // Warmup helpers
        container.register(LifecycleProbe.class);
        container.register(DemoStartup.class);

        // Start: create + wire + init + run startup tasks
        container.start();

        // Report: what's inside the container now
        ContainerReport.print(container);
    }
}
