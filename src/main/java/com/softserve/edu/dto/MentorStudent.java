package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class MentorStudent {
    private String mentorName;
    private List<String> studentNames;
}
