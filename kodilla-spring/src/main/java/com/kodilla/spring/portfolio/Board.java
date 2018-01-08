package com.kodilla.spring.portfolio;

public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board() {
        toDoList = new TaskList();
        inProgressList = new TaskList();
        doneList = new TaskList();
    }

    public void addTaskToDoList(String task) {
        toDoList.addTask(task);
    }

    public void addTaskInProgressList(String task) {
        inProgressList.addTask(task);
    }

    public void addTaskDoneList(String task) {
        doneList.addTask(task);
    }

    public String readToDoList() {
        return toDoList.toString();
    }

    public String readInProgressList() {
        return inProgressList.toString();
    }

    public String readDoneList() {
        return doneList.toString();
    }
}
