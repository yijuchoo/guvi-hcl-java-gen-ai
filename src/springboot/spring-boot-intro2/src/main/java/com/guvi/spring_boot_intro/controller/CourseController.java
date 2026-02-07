package com.guvi.spring_boot_intro.controller;

import com.guvi.spring_boot_intro.dto.CreateCourseRequest;
import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }


    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody CreateCourseRequest request) {

        Course created =
                courseService.createCourse(request.getTitle(),
                        request.getCode());

        return ResponseEntity.status(201).body(created);
    }
}