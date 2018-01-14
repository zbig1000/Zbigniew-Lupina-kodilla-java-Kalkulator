package com.kodilla.patterns.singleton;

enum Logger {
    INSTANCE;
    private String lastLog = "";

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }
}