package com.softserve.edu.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.service.MentorStudentService;
import com.softserve.edu.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

import javax.swing.*;

@Service
public class MarathonServiceImpl implements MarathonService {

    private DataServiceImpl dataService;
    private ScoreService studentScoreService;
    private MentorStudentService mentorStudentService;

    @Autowired
    public MarathonServiceImpl(DataServiceImpl dataService,
                               ScoreService studentScoreService, MentorStudentService mentorStudentService) {
        this.dataService = dataService;
        this.studentScoreService = studentScoreService;
        this.mentorStudentService = mentorStudentService;
    }

    public List<String> getStudents() {
        return dataService.getStudents()
                .stream()
                .map(Entity::getName)
                .collect(Collectors.toList());
    }

    public List<String> getMentors() {
        return dataService.getMentors()
                .stream()
                .map(Entity::getName)
                .collect(Collectors.toList());
    }

    public StudentScore studentResult(String studentName) {
        return studentScoreService.getStudentScoreByStudentName(studentName);
    }

    public List<StudentScore> allStudentsResult() {
        return studentScoreService.getStudentScores();
    }

    public AverageScore studentAverage(String studentName) {
        return studentScoreService.getAvgScore(studentName);
    }

    public List<AverageScore> allStudentsAverage() {
        return studentScoreService.getAllAverageScores();
    }

    public MentorStudent mentorStudents(String mentorName) {
        return mentorStudentService.getMentorStudent(mentorName);
    }
}
