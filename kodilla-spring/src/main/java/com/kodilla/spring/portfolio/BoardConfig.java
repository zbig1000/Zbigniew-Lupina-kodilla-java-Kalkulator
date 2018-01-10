package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }

    @Bean
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean
    public TaskList getDoneList() {
        return new TaskList();
    }

//    @Autowired
//    TaskList toDoList;
//    @Autowired
//    TaskList inProgressList;
//    @Autowired
//    TaskList doneList;
//
//    @Bean
//    public Board getBoard() {
//        return new Board(toDoList, inProgressList, doneList);
//    }
//
//    @Bean
//    @Scope("prototype")
//    public TaskList getTaskList() {
//        return new TaskList();
//    }
}
