package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int user_id;
    private final String user_name;
    private final char gender;
    private final LocalDate birth_date;
    private final int posts_num;

    public ForumUser(final int user_id, final String user_name, final char gender, final LocalDate birth_date, final int posts_num) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.posts_num = posts_num;
    }

    public final int getUser_id() {
        return user_id;
    }

    public final String getUser_name() {
        return user_name;
    }

    public final char getGender() {
        return gender;
    }

    public final LocalDate getBirth_date() {
        return birth_date;
    }

    public final int getPosts_num() {
        return posts_num;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", gender=" + gender +
                ", birth_date=" + birth_date +
                ", posts_num=" + posts_num +
                '}';
    }
}
