package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testLoggerLog() {
        //Given
        Logger logger = Logger.getInstance();
        String newLog  = "new logg";
        logger.log(newLog);

        //When
        logger = Logger.getInstance();
        String resultLog = logger.getLastLog();

        //Then
        Assert.assertEquals(newLog, resultLog);
    }

}
