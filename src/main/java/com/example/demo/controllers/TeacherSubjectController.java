package com.example.demo.controllers;

import com.example.demo.models.Subject;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.SubjectRepository;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherSubjectController {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/lesson")
    private String Main(Model model){
        Iterable<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        Iterable<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);

        return "lesson";
    }

    @PostMapping("/lesson/add")
    public String blogPostAdd(@RequestParam String teacher, @RequestParam String subject, Model model)
    {
        Teacher teacher1 = teacherRepository.findByName(teacher);
        Subject subject1 = subjectRepository.findByName(subject);

        teacher1.getSubjects().add(subject1);
        teacherRepository.save(teacher1);
        return "redirect:/lesson";
    }

}
