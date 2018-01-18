package com.kodilla.patterns.factory.tasks;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryTaskStatus() {
        //Given
        TaskFactory factory = new TaskFactory();
        List<Task> taskList = new ArrayList<>();

        //When
        taskList.add(factory.createTask(TaskFactory.TaskName.PAINTING));
        taskList.add(factory.createTask(TaskFactory.TaskName.DRIVING));
        System.out.println("Initial task list to execute");
        taskList.stream().forEach(System.out::println);

        for (Task task : taskList) {
            task.executeTask();
        }

        //Then
        Assert.assertEquals(true, taskList.get(0).isTaskExecuted());
        Assert.assertEquals(true, taskList.get(1).isTaskExecuted());

        System.out.println("Tasks after executing");
        taskList.stream().forEach(System.out::println);
    }
}
