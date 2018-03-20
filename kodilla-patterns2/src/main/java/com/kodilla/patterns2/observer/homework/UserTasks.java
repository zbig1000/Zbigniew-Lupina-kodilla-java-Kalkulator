package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class UserTasks implements Observable {
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
        notifyObservers(task);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String task) {
        for (Observer observer : observers) {
            observer.updateTasks(task);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
