package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public enum TaskName {
        DRIVING,
        PAINTING,
        SHOPPING
    }

    public Task createTask(TaskName taskName) throws IllegalArgumentException{
        switch (taskName){
            case DRIVING:
                return new DrivingTask("driving task", "Washington", "car");
            case PAINTING:
                return new PaintingTask("painting task", "white", "house");
            case SHOPPING:
                return new ShoppingTask("shopping task", "potatoes", 2.50);
            default:
                throw new IllegalArgumentException();
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
                throw new IllegalArgumentException();
        }
    }

}
