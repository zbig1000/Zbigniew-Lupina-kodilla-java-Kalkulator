package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BoardConfigTestSuite {
    @Test
    public void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board boardOne = context.getBean(Board.class);

        boardOne.addTaskToDoList("OneToDoTask");
        boardOne.addTaskInProgressList("OneInProgressTask");
        boardOne.addTaskDoneList("OneDoneTask");

        //When
        System.out.println(boardOne.readToDoList()+" " + boardOne.readInProgressList()+" "+boardOne.readDoneList());
        // & Then
    }
}
