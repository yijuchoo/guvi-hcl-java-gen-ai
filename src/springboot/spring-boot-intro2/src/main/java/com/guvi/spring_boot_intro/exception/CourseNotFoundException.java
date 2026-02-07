package com.guvi.spring_boot_intro.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String id) {

        super("Course Not Found" + id);
    }
}