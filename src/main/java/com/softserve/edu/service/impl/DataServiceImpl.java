package com.softserve.edu.service.impl;

import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MentorStudentService;
import com.softserve.edu.service.ScoreService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;
    private ScoreService scoreService;
    private MentorStudentService mentorStudentService;

    @Autowired
    public DataServiceImpl(ScoreService scoreService, MentorStudentService mentorStudentService) {
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
        this.sprints = new ArrayList<>();
        this.communication = new ArrayList<>();
        this.solution = new ArrayList<>();
        this.scoreService = scoreService;
        this.mentorStudentService = mentorStudentService;
    }

    public void addStudent(String studentName) {
        students.add(new Entity(studentName));
        scoreService.addStudentScore(studentName);
    }

    public void addMentor(String mentorName) {
        mentors.add(new Entity(mentorName));
        mentorStudentService.addMentorStudent(mentorName);
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

    public void addStudentToMentor(String mentorName, String studentName){
        MentorStudent mentorStudent = mentorStudentService.getMentorStudent(mentorName);
        if(mentorStudent != null){
            mentorStudent.addStudent(studentName);
            addCommunication(studentName, mentorName);
        }
    }

    public Entity getMentor(String mentorName){
        return mentors.stream()
                .filter(o -> o.getName().equals(mentorName))
                .findFirst().orElse(null);
    }

    public void deleteStudent(String studentName) {
        Entity student = this.students
                .stream()
                .filter(o -> o.getName().equals(studentName))
                .findFirst().orElse(null);
        this.students.remove(student);
        scoreService.deleteStudentScore(studentName);
    }

    public void deleteMentor(String mentorName) {
        Entity mentor = this.mentors
                .stream()
                .filter(o -> o.getName().equals(mentorName))
                .findFirst().orElse(null);
        this.mentors.remove(mentor);
        mentorStudentService.deleteMentorStudent(mentorName);
    }

    public void updateStudent(String studentName, String newName) {
        this.students
                .stream()
                .filter(o -> o.getName().equals(studentName))
                .findFirst().ifPresent(student -> student.setName(newName));
        scoreService.updateStudentScore(studentName, newName);
    }

    public void updateMentor(String mentorName, String newName) {
        this.mentors
                .stream()
                .filter(o -> o.getName().equals(mentorName))
                .findFirst().ifPresent(mentor -> mentor.setName(newName));
        mentorStudentService.updateMentorStudent(mentorName, newName);
    }

    public List<String> getMentorsByStudentName(String studentName){
        List<Integer> idMentors = communication.stream()
                .filter(o -> o.getIdStudent() == findIdByName(students, studentName))
                .map(Communication::getIdMentor)
                .collect(Collectors.toList());
        return this.mentors.stream().filter(o -> idMentors.contains(o.getId()))
                .map(Entity::getName).collect(Collectors.toList());
    }

    public int findIdByName(List<Entity> entities, String name) {
        return entities.stream()
                .filter(o -> o.getName().equals(name))
                .map(Entity::getId)
                .findFirst()
                .get();
    }
}
