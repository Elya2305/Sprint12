package com.softserve.edu.service.impl;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentScoreServiceImpl implements ScoreService {
    private List<SprintScore> sprintScores;
    private List<StudentScore> studentScores;
    private List<AverageScore> averageScores;

    public StudentScoreServiceImpl() {
        this.sprintScores = new ArrayList<>();
        this.studentScores = new ArrayList<>();
        this.averageScores = new ArrayList<>();
    }

    public void addSprintScore(String sprintName, int score) {
        sprintScores.add(new SprintScore(sprintName, score));
    }

    public void addStudentScore(String studentName) {
        studentScores.add(new StudentScore(studentName));
    }

    public void addAverageScore(String studentName, double avgScore) {
        averageScores.add(new AverageScore(studentName, avgScore));
    }

    public void addSprintScoreToStudentScore(String studentName, String sprintName, int score) {
        studentScores
                .stream()
                .filter(o -> o.getStudentName().equals(studentName))
                .findFirst()
                .ifPresent(studentScore ->
                        studentScore.addSprintScore(getSprintScore(sprintName, score)));
    }

    public void deleteStudentScore(String studentName) {
        StudentScore studentScore = studentScores.stream()
                .filter(o -> o.getStudentName()
                        .equals(studentName))
                .findFirst().orElse(null);
        studentScores.remove(studentScore);
    }

    public void updateStudentScore(String studentName, String newName) {
        studentScores.stream()
                .filter(o -> o.getStudentName().equals(studentName))
                .findFirst()
                .ifPresent(o -> o.setStudentName(newName));
    }

    public SprintScore getSprintScore(String sprintName, int score) {
        SprintScore sprintScore = sprintScores.stream()
                .filter(o -> o.getScore() == score && o.getSprintName().equals(sprintName))
                .findFirst()
                .orElse(new SprintScore(sprintName, score));
        sprintScores.add(sprintScore);
        return sprintScore;
    }

    public List<SprintScore> getListOfScores(String studentName) {
        return studentScores
                .stream()
                .filter(o -> o.getStudentName().equals(studentName))
                .findFirst()
                .map(StudentScore::getSprintScores)
                .orElse(null);
    }

    public StudentScore getStudentScoreByStudentName(String studentName){
        return studentScores.stream()
                .filter(o -> o.getStudentName().equals(studentName))
                .findFirst()
                .orElse(null);
    }

    public List<StudentScore> getStudentScores(){
        return studentScores;
    }

    public AverageScore getAvgScore(String studentName){
        double avg = getStudentScoreByStudentName(studentName)
                .getSprintScores()
                .stream()
                .mapToInt(SprintScore::getScore)
                .average()
                .orElse(0);
        AverageScore averageScore = new AverageScore(studentName, avg);
        averageScores.add(averageScore);
        return averageScore;
    }

    public List<AverageScore> getAllAverageScores(){
        System.out.println(averageScores);
        return averageScores;
    }
}
