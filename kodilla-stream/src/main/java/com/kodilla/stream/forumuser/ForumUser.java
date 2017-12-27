package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int userId;
    private final String userName;
    private final char gender;
    private final LocalDate birthDate;
    private final int postsNum;

    public ForumUser(final int userId, final String userName, final char gender, final LocalDate birthDate, final int postsNum) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postsNum = postsNum;
    }

    public final int getUserId() {
        return userId;
    }

    public final String getUserName() {
        return userName;
    }

    public final char getGender() {
        return gender;
    }

    public final LocalDate getBirthDate() {
        return birthDate;
    }

    public final int getPostsNum() {
        return postsNum;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", postsNum=" + postsNum +
                '}';
    }
}
