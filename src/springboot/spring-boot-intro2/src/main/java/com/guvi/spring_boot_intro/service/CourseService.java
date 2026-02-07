package com.guvi.spring_boot_intro.service;

import com.guvi.spring_boot_intro.exception.CourseNotFoundException;
import com.guvi.spring_boot_intro.exception.DuplicateCourseException;
import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.repo.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }
    public Course createCourse(String title, String code){
        courseRepo.findByCodeIgnoreCase(code)
                .ifPresent(existing ->{ throw new DuplicateCourseException(code);}
                );
        Course course = new Course(true, null, title, code);
        courseRepo.save(course);
        return course;
    }

    public Course getCourseById(String id){
        return courseRepo.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }
}