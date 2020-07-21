package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class MentorStudent {
    private String mentorName;
    private List<String> studentNames;

    public MentorStudent(String mentorName) {
        this.mentorName = mentorName;
        this.studentNames = new ArrayList<>();
    }
}
