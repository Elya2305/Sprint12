package com.softserve.edu;

import java.util.List;

import com.softserve.edu.entity.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {
    
    @Autowired
    private MarathonService marathonService;
    
    @Autowired
    private DataService dataService;

    public ApplicationTest() {
        fillDataService();
    }
    
    private void fillDataService() {
        dataService.addStudent("Elya");
        dataService.addStudent("Den");

        dataService.addMentor("Olga");
        dataService.addMentor("Oleg");

        // TODO for dataService
    }
    
    @Test
    public void checkGetStudents() {
        List<String> expected = null;
        List<String> actual = marathonService.getStudents();
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

}
