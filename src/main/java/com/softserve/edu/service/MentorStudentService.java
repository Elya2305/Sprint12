package com.softserve.edu.service;

import com.softserve.edu.dto.MentorStudent;

public interface MentorStudentService {

    void addMentorStudent(String mentorName);

    void deleteMentorStudent(String mentorName);

    void updateMentorStudent(String mentorName, String newName);

    MentorStudent getMentorStudent(String mentorName);
}
