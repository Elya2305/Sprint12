package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class SprintScore {
    private String sprintName;
    private int score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprintScore that = (SprintScore) o;
        return score == that.score &&
                Objects.equals(sprintName, that.sprintName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sprintName, score);
    }
}
