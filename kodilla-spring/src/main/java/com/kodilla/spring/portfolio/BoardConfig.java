package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    TaskList taskListOne;
    @Autowired
    TaskList toDoList;
    @Autowired
    TaskList inProgressList;

    @Bean
    public Board getBoard() {
        return new Board(taskListOne, toDoList, inProgressList);
    }

    @Bean
    @Scope("prototype")
    public TaskList getTaskList() {
        return new TaskList();
    }
}
