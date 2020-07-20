package com.softserve.edu.service.impl;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private List<SprintScore> sprintScores;
    private List<StudentScore> studentScores;
    private List<AverageScore> averageScores;

    public ScoreServiceImpl() {
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

    public void addSprintScoreToStudentScore(String studentName, int score){
        studentScores
                .stream()
                .filter(o -> o.getStudentName().equals(studentName))
                .findFirst()
                .ifPresent(studentScore ->
                        studentScore.addSprintScore(getSprintScore(studentName, score)));
    }

    public SprintScore getSprintScore(String sprintName, int score){
        return sprintScores.stream()
                .filter(o -> o.getScore() == score && o.getSprintName().equals(sprintName))
                .findFirst()
                .orElse(new SprintScore(sprintName, score));
    }
}
