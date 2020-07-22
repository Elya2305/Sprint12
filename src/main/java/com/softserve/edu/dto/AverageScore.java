package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class AverageScore {
    private String studentName;
    private double avgScore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AverageScore that = (AverageScore) o;
        return Double.compare(that.avgScore, avgScore) == 0 &&
                Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, avgScore);
    }

    @Override
    public String toString() {
        return "AverageScore{" +
                "studentName='" + studentName + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }
}
