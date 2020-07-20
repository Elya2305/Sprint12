package com.softserve.edu.service.impl;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtoServiceImpl {
    private List<SprintScore> sprintScores;
    private List<StudentScore> studentScores;
    private List<AverageScore> averageScores;

    public DtoServiceImpl() {
        this.sprintScores = new ArrayList<>();
        this.studentScores = new ArrayList<>();
        this.averageScores = new ArrayList<>();
    }

    public void addSprintScore(String sprintName, int score){
        sprintScores.add(new SprintScore(sprintName, score));
    }

    public void addStudentScore(String studentName){
        studentScores.add(new StudentScore(studentName));
    }

    public void addAverageScore(String studentName, double avgScore){
        averageScores.add(new AverageScore(studentName, avgScore));
    }
}
