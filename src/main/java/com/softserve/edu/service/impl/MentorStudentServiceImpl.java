package com.softserve.edu.service.impl;

import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MentorStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorStudentServiceImpl implements MentorStudentService {
    List<MentorStudent> mentorStudents;
//    private DataService dataService;

    @Autowired
    public MentorStudentServiceImpl() {
        this.mentorStudents = new ArrayList<>();
//        this.dataService = dataService;
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
