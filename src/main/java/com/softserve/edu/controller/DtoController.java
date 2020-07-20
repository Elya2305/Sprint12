package com.softserve.edu.controller;

import com.softserve.edu.service.DataService;
import com.softserve.edu.service.ScoreService;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DtoController {

    DataServiceImpl dataService;
    ScoreService scoreService;


    @Autowired
    public DtoController(DataServiceImpl dataService, ScoreService scoreService) {
        this.dataService = dataService;
        this.scoreService = scoreService;
    }

    @GetMapping("/students")
    public String getStudent(Model model) {
        model.addAttribute("students", dataService.getStudents());
        return "students";
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String studentName, Model model) {
        dataService.addStudent(studentName);
        model.addAttribute("students", dataService.getStudents());
        return "students";
    }

    @PostMapping("/student-info")
    public String getStudentInfo(@RequestParam String studentName, Model model) {
        model.addAttribute("studentName", studentName);
        return "student-info";
    }

    public String addScore(String studentName, int score){
        scoreService.addSprintScore(studentName, score);
        return "student-info";
    }

}
