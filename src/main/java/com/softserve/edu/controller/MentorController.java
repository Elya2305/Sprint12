package com.softserve.edu.controller;

import com.softserve.edu.service.ScoreService;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mentors")
public class MentorController {
    DataServiceImpl dataService;

    @Autowired
    public MentorController(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public String getMentors(Model model){
        model.addAttribute("mentors", dataService.getMentors());
        return "mentors";
    }

    @PostMapping
    public String addMentor(@RequestParam String mentorName){
        dataService.addMentor(mentorName);
        return "redirect:/mentors";
    }

    @PostMapping("/delete")
    public String deleteMentor(@RequestParam String mentorName){
        dataService.deleteStudent(mentorName);

        return "redirect:/students";
    }
}
