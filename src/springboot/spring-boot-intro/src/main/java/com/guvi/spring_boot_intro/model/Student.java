package com.guvi.spring_boot_intro.model;

import java.util.UUID;

public class Student {
    // TODO:
    // Fields: UUID id, String name, String email
    private UUID id;
    private String name;
    private String email;

    // Constructor: Student(UUID id, String name, String email)
    public Student(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    // toString()
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name
                + '\'' + ", email='" + email + '\'' + '}';
    }
}
