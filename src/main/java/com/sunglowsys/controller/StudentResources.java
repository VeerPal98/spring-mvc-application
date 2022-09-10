package com.sunglowsys.controller;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentResources {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        List<Student> students = studentService.findAll();
        return students;
    }

    @PutMapping("/students/{id}")
    public Student update(@RequestBody Student student, @PathVariable("id") Long id){
        return studentService.update(student,id);
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable("id") Long id){
        studentService.delete(id);
    }
}

