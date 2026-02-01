package com.guvi.spring_boot_intro.repo;

import com.guvi.spring_boot_intro.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryStudentRepository implements StudentRepository {

    // TODO:
    // Pick one:
    // 1) Map<UUID, Student> store = new HashMap<>();
    // 2) List<Student> store = new ArrayList<>();
    Map<UUID, Student> store = new HashMap<>();

    @Override
    public void save(Student student) {
        // TODO: store the student
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
        // TODO: return student if present
        if(store.containsKey(id)){
            return Optional.ofNullable(store.get(id));
        }else {
            System.out.println("Student not found with the id: "+id);
            return Optional.empty();
        }
    }

    @Override
    public List<Student> findAll() {
        // TODO: return all students
        List<Student> list = new ArrayList<>();
        if (store.isEmpty()){
            System.out.println("No records found !!");
            return new ArrayList<>();
        }else {
            list.addAll(store.values());
        }
        return list;
    }
}
