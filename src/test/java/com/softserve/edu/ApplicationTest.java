package com.softserve.edu;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;
import com.softserve.edu.service.ScoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {
    
    private MarathonService marathonService;
    private DataService dataService;
    private ScoreService scoreService;
    private static int counter;

    @Autowired
    public ApplicationTest(MarathonService marathonService,
                             DataService dataService, ScoreService scoreService ) {
        this.marathonService = marathonService;
        this.dataService = dataService;
        this.scoreService = scoreService;
        if(counter++ == 0){
            fillDataService();
        }
    }

    public void fillDataService() {
        dataService.addStudent("Elya");
        dataService.addStudent("Den");

        dataService.addMentor("Natalia");
        dataService.addMentor("Mykola");

        scoreService.addSprintScoreToStudentScore("Den", "Sprint #1", 90);
        scoreService.addSprintScoreToStudentScore("Den", "Sprint #2", 100);
        scoreService.addSprintScoreToStudentScore("Den", "Sprint #3", 90);
        scoreService.addSprintScoreToStudentScore("Den", "Sprint #4", 100);
        scoreService.addSprintScoreToStudentScore("Elya", "Sprint #1", 100);

        dataService.addStudentToMentor("Natalia", "Elya");
        dataService.addStudentToMentor("Mykola", "Den");
    }
    
    @Test
    public void checkGetStudents() {
        List<String> expected = List.of("Elya", "Den");
        List<String> actual = marathonService.getStudents();
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

    @Test
    public void checkGetMentors() {
        List<String> expected = List.of("Natalia", "Mykola");
        List<String> actual = marathonService.getMentors();
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

    @Test
    public void checkStudentResult(){
        StudentScore actual = marathonService.studentResult("Den");
        StudentScore expected = new StudentScore("Den");
        List<SprintScore> expectedList = new ArrayList<>(){{
            add(new SprintScore("Sprint #1", 90));
            add(new SprintScore("Sprint #2", 100));
            add(new SprintScore("Sprint #3", 90));
            add(new SprintScore("Sprint #4", 100));
        }};
        expected.setSprintScores(expectedList);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkAllStudentsResult() {
        List<StudentScore> actual = marathonService.allStudentsResult();
        List<StudentScore> expected = new ArrayList<>();
        List<SprintScore> expectedList1 = new ArrayList<>(){{
            add(new SprintScore("Sprint #1", 90));
            add(new SprintScore("Sprint #2", 100));
            add(new SprintScore("Sprint #3", 90));
            add(new SprintScore("Sprint #4", 100));
        }};
        List<SprintScore> expectedList2 = new ArrayList<>(){{
            add(new SprintScore("Sprint #1", 100));
        }};

        StudentScore studentScoreDen = new StudentScore("Den");
        studentScoreDen.setSprintScores(expectedList1);

        StudentScore studentScoreElya = new StudentScore("Elya");
        studentScoreElya.setSprintScores(expectedList2);

        expected.add(studentScoreElya);
        expected.add(studentScoreDen);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkStudentAverage(){
        AverageScore actual = marathonService.studentAverage("Den");
        AverageScore expected = new AverageScore("Den", 95.0);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkAllStudentsAverage(){
        List<AverageScore> actual = marathonService.allStudentsAverage();
        List<AverageScore> expected = new ArrayList<>(){{
            add(marathonService.studentAverage("Den"));
            add(marathonService.studentAverage("Elya"));
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkMentorStudents(){
        MentorStudent actual = marathonService.mentorStudents("Natalia");
        MentorStudent expected = new MentorStudent("Natalia");
        List<String> studentNames = new ArrayList<>(){{
            add("Elya");
        }};
        expected.setStudentNames(studentNames);
        Assertions.assertEquals(expected, actual);
    }

}
