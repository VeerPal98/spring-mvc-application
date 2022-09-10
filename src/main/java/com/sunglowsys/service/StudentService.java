package com.sunglowsys.service;

import com.sunglowsys.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);

    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student update(Student student, Long id);

    void  delete(Long id);

    Student findById();
}
