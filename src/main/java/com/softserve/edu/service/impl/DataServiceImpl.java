package com.softserve.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Getter
public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;

    public DataServiceImpl() {
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
        this.sprints = new ArrayList<>();
        this.communication = new ArrayList<>();
        this.solution = new ArrayList<>();
    }

    public void addStudent(String studentName) {
        students.add(new Entity(studentName));
    }

    public void addMentor(String mentorName) {
        mentors.add(new Entity(mentorName));
    }

    public void addSprint(String sprintName) {
        sprints.add(new Entity(sprintName));
    }

    public void addCommunication(String studentName, String mentorName) {
        communication.add(new Communication(
                findIdByName(students, studentName),
                findIdByName(mentors, mentorName)
        ));
    }

    public void addSolution(String studentName, String sprintName, int score) {
        solution.add(new Solution(
                findIdByName(students, sprintName),
                findIdByName(sprints, sprintName),
                score
        ));
    }

    public int findIdByName(List<Entity> entities, String name) {
        return entities.stream()
                .filter(o -> o.getName().equals(name))
                .map(Entity::getId)
                .findFirst()
                .get();
    }
}
