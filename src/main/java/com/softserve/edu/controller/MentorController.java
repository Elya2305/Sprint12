package com.softserve.edu.controller;

import com.softserve.edu.service.ScoreService;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        dataService.deleteMentor(mentorName);
        return "redirect:/mentors";
    }

    @GetMapping("/update/{mentorName}")
    public String getUpdateMentor(@PathVariable String mentorName, Model model){
        model.addAttribute("name", mentorName);
        model.addAttribute("entity", "mentors");
        return "update";
    }

    @PostMapping("/postUpdate")
    public String postUpdateStudent(@RequestParam String oldName,
                                    @RequestParam String newName, Model model){
        dataService.updateMentor(oldName, newName);
        model.addAttribute("mentorName", newName);
        model.addAttribute("mentors", dataService.getMentors());
        return "mentors";
    }
}
