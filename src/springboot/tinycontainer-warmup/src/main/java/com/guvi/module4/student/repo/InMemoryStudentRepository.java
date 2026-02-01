package com.guvi.module4.student.repo;

import com.guvi.module4.student.model.Student;

import java.util.*;
import javax.swing.text.html.Option;

public class InMemoryStudentRepository implements StudentRepository {

    Map<UUID, Student> store = new HashMap<>();

    @Override
    public void save(Student student) {
        if(student == null){
            System.out.println("Invalid input");
        }
        else if(!store.containsValue(student)){
            store.put(student.getId(), student);
        }
        else {
            System.out.println("Student already exits !!");
        }
    }

    @Override
    public Optional<Student> findById(UUID id) {
        if(store.containsKey(id)){
            return Optional.ofNullable(store.get(id));
        }else {
            System.out.println("Student not found with the id: "+id);
            return Optional.empty();
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        if (store.isEmpty()){
            System.out.println("No records found !!");
            return new ArrayList<>();
        }else {
            list.addAll(store.values());
        }
        return list;
    }

    // TODO (Task: Find Student by Email)
    // 2) Implement findByEmail(String email)
    //    Steps:
    //    1) If email is null/blank, return Optional.empty()
    //    2) Loop through store.values()
    //    3) If a student's email matches the input email, return Optional.of(student)
    //       - Decide if you want equals() or equalsIgnoreCase()
    //    4) If no match, return Optional.empty()
    // NOTE: This method will only compile after you add the method definition in StudentRepository.
    //
    @Override
    public Optional<Student> findByEmail(String email) {
        // TODO 2) Implement logic here
        if (email == null || email.isBlank()){
            return   Optional.empty();
        }
        // for loop, for-each loop, stream
        for (Student student : store.values()){
            if (student.getEmail().equals(email)){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
}