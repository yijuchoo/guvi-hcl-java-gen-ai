package com.guvi.spring_boot_intro.controller;

import com.guvi.spring_boot_intro.dto.CreateStudentRequest;
import com.guvi.spring_boot_intro.dto.StudentPageResponseV2;
import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // http://localhost:9000/students
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // New query param (q):
    // GET /students?q=yirou
    // GET /students?q=yirou&sortBy=email&sortDir=desc
    // GET /students?q=example.com
    // GET /students?q=shalini@example.com -> will only return results that match string "shalini@example.com"
    @GetMapping()
    public StudentPageResponseV2<Student> listStudents(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDir,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        // q can be a search on name or email
        String search = q;
        if (search == null || search.isBlank()) {
            if (name != null && !name.isBlank()) {
                search = name;
            } else if (email != null && !email.isBlank()) {
                search = email;
            }
        }
        return studentService.searchStudents(active, search, sortBy, sortDir, page, size);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student created = studentService.createStudent(request.getName(), request.getEmail());
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @Valid @RequestBody CreateStudentRequest request) {
        return studentService.updateStudent(id, request.getName(), request.getEmail());
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
