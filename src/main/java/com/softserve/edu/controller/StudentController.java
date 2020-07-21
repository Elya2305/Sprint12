package com.softserve.edu.controller;

import com.softserve.edu.service.ScoreService;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    DataServiceImpl dataService;
    ScoreService scoreService;

    @Autowired
    public StudentController(DataServiceImpl dataService, ScoreService scoreService) {
        this.dataService = dataService;
        this.scoreService = scoreService;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", dataService.getStudents());
        return "students";
    }

    @PostMapping
    public String addStudent(@RequestParam String studentName) {
        dataService.addStudent(studentName);
        return "redirect:/students";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam String studentName){
        dataService.deleteStudent(studentName);
        return "redirect:/students";
    }

    @GetMapping("/update/{studentName}")
    public String getUpdateStudent(@PathVariable String studentName, Model model){
        model.addAttribute("name", studentName);
        model.addAttribute("entity", "students");
        return "update";
    }

    @PostMapping("/postUpdate")
    public String postUpdateStudent(@RequestParam String oldName,
                                    @RequestParam String newName, Model model){
        dataService.updateStudent(oldName, newName);
        model.addAttribute("studentName", newName);
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
    public String addScore(@PathVariable("studentName") String studentName,
            @RequestParam String sprintName, @RequestParam int score){
        scoreService.addSprintScoreToStudentScore(studentName, sprintName, score);
        return "redirect:/students/" + studentName;
    }
}
