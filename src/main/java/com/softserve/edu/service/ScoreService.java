package com.softserve.edu.service;

import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;

import java.util.List;

public interface ScoreService {
    void addSprintScore(String sprintName, int score);

    void addStudentScore(String studentName);

    void addAverageScore(String studentName, double avgScore);

    public void addSprintScoreToStudentScore(String studentName, int score);

    public List<SprintScore> getListOfScores(String studentName);
}
