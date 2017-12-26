package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(001,"Stanisław Kowalski", 'M', LocalDate.of(1951,01,02), 0 ));
        theUserList.add(new ForumUser(002,"Jan Ziemnicki", 'M', LocalDate.of(2001,02,02), 1 ));
        theUserList.add(new ForumUser(003,"Ola Alanina ", 'W', LocalDate.of(1981,03,02), 16 ));
        theUserList.add(new ForumUser(004,"Ania Jakóbiak", 'W', LocalDate.of(1996,12,20), 20 ));
        theUserList.add(new ForumUser(005,"Tadeusz Lewandowski", 'M', LocalDate.of(2000,05,02), 8 ));
        theUserList.add(new ForumUser(006,"Zbigniew Tylski", 'M', LocalDate.of(1965,06,02), 22 ));
        theUserList.add(new ForumUser(007,"Andrzej Wawyszak", 'M', LocalDate.of(1996,12,25), 40 ));

    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
