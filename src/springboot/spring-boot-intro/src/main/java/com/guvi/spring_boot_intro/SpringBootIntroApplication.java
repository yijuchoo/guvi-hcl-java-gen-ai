package com.guvi.spring_boot_intro;

import com.guvi.spring_boot_intro.service.AttendanceService;
import com.guvi.spring_boot_intro.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.UUID;

// Entry Point
@SpringBootApplication
public class SpringBootIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

	/*
	* CommandLineRunner - a Spring Boot hook that lets you run
	* some code after the application starts
	* @Bean -> registering a CommandLineRunner object
    */
    @Bean
    CommandLineRunner runOnStartup(StudentService studentService, AttendanceService attendanceService) {
		return args -> {
            UUID id = studentService.registerStudent("Ashik", "ashik@gmail.com");
            attendanceService.markPresent(id, LocalDate.now());

            System.out.println(studentService.listStudents());
        };
    }
}
