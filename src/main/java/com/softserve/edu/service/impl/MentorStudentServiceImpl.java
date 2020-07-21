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
}
