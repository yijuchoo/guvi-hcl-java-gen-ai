package com.guvi.spring_boot_intro.bootstrap;

import java.time.Instant;
import java.util.List;

import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.model.Enrollment;
import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.repo.CourseRepository;
import com.guvi.spring_boot_intro.repo.EnrollmentRepository;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 new Student(null, "malini", "ma@example.com", true);
 new Student(null, "ashik", "as@example.com", true);
 new Student(null, "thirumalini", "t-malini@example.com", false);
 new Student(null, "shalini", "sh@example.com", true);
 new Student(null, "thirumani", "th@example.com", true);
 new Student(null, "yirou", "yi@example.com", false);
 new Student(null, "armaan", "ar@example.com", true);
 new Student(null, "ashwin", "ash@example.com", true);
 */
@Component
public class DataSeeder implements CommandLineRunner {
    private final StudentRepository repo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollRepo;

    public DataSeeder(StudentRepository repo, CourseRepository courseRepo,
                      EnrollmentRepository enrollRepo) {
        this.repo = repo;
        this.courseRepo = courseRepo;
        this.enrollRepo = enrollRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // insert only if the count (number of documents in the collection) == 0
        if(repo.count() > 0) {
            return;
        }
        // need a list of students to save
        List<Student> students = List.of(
            new Student(null, "malini", "ma@example.com", true),
            new Student(null, "ashik", "as@example.com", true),
            new Student(null, "thirumalini", "t-malini@example.com", false),
            new Student(null, "shalini", "sh@example.com", true),
            new Student(null, "thirumani", "th@example.com", true),
            new Student(null, "yirou", "yi@example.com", false),
            new Student(null, "armaan", "ar@example.com", true),
            new Student(null, "ashwin", "ash@example.com", true)
        );
        System.out.println("Saving students: " + students);

        // repo save all the students
        repo.saveAll(students);

        if(courseRepo.count() > 0) {
            return;
        }
        // need a list of courses to save
        List<Course> courses = List.of(
                new Course(true, null, "Spring Boot Foundations", "SB101"),
                new Course(true, null, "Spring Boot Advanced", "SB201"),
                new Course(false, null, "Database", "DB200"),
                new Course(true, null, "Java Foundations", "J101"),
                new Course(false, null, "Data Structure Algorithm", "DSA")
        );
        System.out.println("Saving courses: " + courses);

        // repo save all the courses
        courseRepo.saveAll(courses);

        if(enrollRepo.count() > 0) {
            return;
        }
        // need a list of courses to save
        List<Enrollment> enrollments = List.of(
                new Enrollment(null, "69860bcd0bd58452c80c053e", "69860bcd0bd58452c80c0546", Instant.now(), "ACTIVE"),
                new Enrollment(null, "69860bcd0bd58452c80c053f", "69860bcd0bd58452c80c0547", Instant.now(), "CANCELLED"),
                new Enrollment(null, "69860bcd0bd58452c80c053f", "69860bcd0bd58452c80c0548", Instant.now(), "ACTIVE"),
                new Enrollment(null, "69860bcd0bd58452c80c0540", "69860bcd0bd58452c80c0547", Instant.now(), "CANCELLED"),
                new Enrollment(null, "69860bcd0bd58452c80c0541", "69860bcd0bd58452c80c0549", Instant.now(), "ACTIVE")
        );
        System.out.println("Saving enrollments: " + enrollments);

        // repo save all the enrollments
        enrollRepo.saveAll(enrollments);
    }
}
/*
repo.saveAll -> saves the list of students; id = null, means the MongoDB should generate the ObjectIds
DTO - HTTP request/response
*/