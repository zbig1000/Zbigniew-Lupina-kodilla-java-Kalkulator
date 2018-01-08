package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    List<String> tasks;

    public TaskList() {
        tasks =  new ArrayList<>();
    }
    public void addTask(String task){
        tasks.add(task);
    }

    @Override
    public String toString() {
        return tasks.stream()
                .collect(Collectors.joining(" ", "", ""));
    }
}
