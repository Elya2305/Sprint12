package com.softserve.edu.service;


public interface DataService {

    void addStudent(String studentName);

    void addMentor(String mentorName);

    void addSprint(String sprintName);

    void addCommunication(String studentName, String mentorName);

    void addSolution(String studentName, String sprintName, int score);

}
