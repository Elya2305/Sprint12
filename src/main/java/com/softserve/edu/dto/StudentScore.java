package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentScore {
    private String studentName;
    private List<SprintScore> sprintScores;

    public StudentScore(String studentName) {
        this.studentName = studentName;
        sprintScores = new ArrayList<>();
    }
    public void addSprintScore(SprintScore sprintScore){
        sprintScores.add(sprintScore);
    }
}
