package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final static String DRIVIG = "DRIVIG";
    public final static String PAINTING = "PAINTING";
    public final static String SHOPPING = "SHOPPING";

    public Task createTask(String taskName){
        switch (taskName){
            case DRIVIG:
                return new DrivingTask("driving task", "Washington", "car");
            case PAINTING:
                return new PaintingTask("painting task", "white", "house");
            case SHOPPING:
                return new ShoppingTask("shopping task", "potatoes", 2.50);
            default:
                return null;
        }
    }

    public Task createTaskNum(int taskNum){
        int taskSelector = taskNum;
        if (taskNum > 3) { taskSelector = taskNum % 3; }
        switch (taskSelector){
            case 1:
                return new DrivingTask("driving task", "Washington", "car");
            case 2:
                return new PaintingTask("painting task", "white", "house");
            case 3:
                return new ShoppingTask("shopping task", "potatoes", 2.50);
            default:
                return null;
        }
    }

}
