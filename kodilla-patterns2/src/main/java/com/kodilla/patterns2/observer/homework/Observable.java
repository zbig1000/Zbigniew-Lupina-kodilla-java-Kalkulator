package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver (Observer observer);
    void notifyObservers(String task);
    void removeObserver(Observer observer);
}
