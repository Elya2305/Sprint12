package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
}
