package com.kodilla.patterns2.observer.homework;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTasksTestSuite {

    @Test
    public void testUserTasks() {
        //Given
        UserTasks zbigTasks = new UserTasks("Zbig Lupina");
        Mentor mentor = new Mentor("Artur Kluz");
        zbigTasks.registerObserver(mentor);
        //When
        zbigTasks.addTask("zadanie 20.1");
        zbigTasks.addTask("zadanie 20.2");
        zbigTasks.addTask("zadanie 20.3");
        //Then
        assertEquals(3, mentor.getUpdateCount());
    }
}
