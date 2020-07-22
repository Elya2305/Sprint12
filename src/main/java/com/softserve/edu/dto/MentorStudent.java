package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class MentorStudent {
    private String mentorName;
    private List<String> studentNames;

    public MentorStudent(String mentorName) {
        this.mentorName = mentorName;
        this.studentNames = new ArrayList<>();
    }

    public void addStudent(String studentName){
        studentNames.add(studentName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentorStudent that = (MentorStudent) o;
        return Objects.equals(mentorName, that.mentorName) &&
                Objects.equals(studentNames, that.studentNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorName, studentNames);
    }

    @Override
    public String toString() {
        return "MentorStudent{" +
                "mentorName='" + mentorName + '\'' +
                ", studentNames=" + studentNames +
                '}';
    }
}
