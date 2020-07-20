package com.softserve.edu.service;

public interface ScoreService {
    void addSprintScore(String sprintName, int score);

    void addStudentScore(String studentName);

    void addAverageScore(String studentName, double avgScore);
}
