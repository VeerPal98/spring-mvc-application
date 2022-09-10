package com.sunglowsys.controller;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("students" , studentService.findAll());
        return "index";
    }

    @GetMapping("/showAddStudentForm")
    public String showAddStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";
    }

    @PostMapping("/saveStudent")
    public String saveEmployee(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/home";
    }

    @GetMapping("/showUpdateStudentForm/{id}")
    public String showUpdateStudentForm(@PathVariable(value = "id") Long id, Model model){
        Student student = studentService.findById();
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.delete(id);
        return "redirect:/home";
    }
}

