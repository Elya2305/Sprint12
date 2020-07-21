package com.softserve.edu.service.impl;

import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.service.MentorStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorStudentServiceImpl implements MentorStudentService {
    List<MentorStudent> mentorStudents;

    public MentorStudentServiceImpl() {
        this.mentorStudents = new ArrayList<>();
    }

    public void addMentorStudent(String mentorName){
        mentorStudents.add(new MentorStudent(mentorName));
    }

    public void deleteMentorStudent(String mentorName){
        mentorStudents.remove(mentorStudents.stream()
                .filter(o -> o.getMentorName().equals(mentorName))
                .findFirst()
                .orElse(null));
    }

    public void updateMentorStudent(String mentorName, String newName){
        mentorStudents.stream()
                .filter(o -> o.getMentorName().equals(mentorName))
                .findFirst().ifPresent(o -> o.setMentorName(newName));
    }

    public MentorStudent getMentorStudent(String mentorName){
        return mentorStudents.stream()
                .filter(o -> o.getMentorName().equals(mentorName))
                .findFirst().orElse(null);
    }
}
