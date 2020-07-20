package com.softserve.edu.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

import javax.swing.*;

@Service
public class MarathonServiceImpl implements MarathonService {

    private DataServiceImpl dataService;
    private List<SprintScore> sprintScores;

    @Autowired
    public MarathonServiceImpl(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    public List<String> getStudents() {
        return dataService.getStudents()
                .stream()
                .map(Entity::getName)
                .collect(Collectors.toList());
    }

    public List<String> getMentors() {
        return dataService.getMentors()
                .stream()
                .map(Entity::getName)
                .collect(Collectors.toList());
    }

    public StudentScore studentResult(String studentName) {
/*        dataService.getSolution()
                .stream()
                .filter(o -> o.getIdStudent() == dataService
                        .findIdByName(dataService.getStudents(), studentName))*/
        // TODO
        return null;
    }

    public List<StudentScore> allStudentsResult() {
        // TODO
        return null;
    }

    public AverageScore studentAverage(String studentName) {
        // TODO
        return null;
    }

    public List<AverageScore> allStudentsAverage() {
        // TODO
        return null;
    }

    public MentorStudent mentorStudents(String mentorName) {
        // TODO
        return null;
    }

}
