package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mentor implements Observer{
    private final String mentorName;
    private int updateCount;
    List<String> metorTasks = new ArrayList<>();

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void updateTasks(String userTask) {
        System.out.println(mentorName + ": New task in the que ");
        metorTasks.add(userTask);
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }

}
