package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class UserTasks implements Observable, TaskPublisher {
    private final List<Observer> observers;
    private final List<String> tasks;
    private final String name;

    public UserTasks(String name) {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public final List<String> getTasks() {
        return tasks;
    }

    @Override
    public String getName() {
        return name;
    }
}
