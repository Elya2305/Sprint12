package com.softserve.edu.service;

import com.softserve.edu.dto.SprintScore;

import java.util.List;

public interface ScoreService {
    void addSprintScore(String sprintName, int score);

    void addStudentScore(String studentName);

    void addAverageScore(String studentName, double avgScore);

    void addSprintScoreToStudentScore(String studentName, String sprintName, int score);

    List<SprintScore> getListOfScores(String studentName);

    void deleteStudentScore(String studentName);

    void updateStudentScore(String studentName, String newName);
}
