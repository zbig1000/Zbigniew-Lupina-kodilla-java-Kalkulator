package com.kodilla.stream.immutable;

public class ForumUser {
    private final String username;
    private final String realName;

    public ForumUser(final String username,final String realName) {
        this.username = username;
        this.realName = realName;
    }

    public final String getUsername() {
        return username;
    }

    public final String getRealName() {
       return realName;
    }
}
