package com.kodilla.patterns.singleton;

enum Logger {
    INSTANCE;
    private String lastLog = "";

    public static Logger getInstance()
    {
        return INSTANCE;
    }


//    public static Logger getInstance() {
//        return LoggerHelper.INSTANCE;
//    }
//
//    private static class LoggerHelper {
//        private static final Logger INSTANCE = new Logger();
//    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }
}