package com.softserve.edu.controller;

import com.softserve.edu.service.DataService;
import com.softserve.edu.service.ScoreService;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class DtoController {

    DataServiceImpl dataService;
    ScoreService scoreService;


    @Autowired
    public DtoController(DataServiceImpl dataService, ScoreService scoreService) {
        this.dataService = dataService;
        this.scoreService = scoreService;
    }

    @GetMapping
    public String getStudent(Model model) {
        model.addAttribute("students", dataService.getStudents());
        return "students";
    }

    @PostMapping
    public String addStudent(@RequestParam String studentName, Model model) {
        dataService.addStudent(studentName);
        model.addAttribute("students", dataService.getStudents());
        return "students";
    }

    @GetMapping("/{studentName}")
    public String getStudentInfo(@PathVariable String studentName, Model model) {
        model.addAttribute("studentName", studentName);
        model.addAttribute("scores", scoreService.getListOfScores(studentName));
        return "student-info";
    }

    @PostMapping("/{studentName}")
    public String addScore(@PathVariable String studentName, int score){
        scoreService.addSprintScore(studentName, score);
        return "redirect:/{studentName}";
    }
}
