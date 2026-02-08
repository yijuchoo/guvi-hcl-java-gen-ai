package com.guvi.spring_boot_intro.exception;

public class DuplicateCourseException extends RuntimeException {
    public DuplicateCourseException(String code) {
        super("Course already exists: " + code);
    }
}