package com.softserve.edu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentScore that = (StudentScore) o;
        return Objects.equals(studentName, that.studentName) &&
                Objects.equals(sprintScores, that.sprintScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, sprintScores);
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "studentName='" + studentName + '\'' +
                ", sprintScores=" + sprintScores +
                '}';
    }
}
