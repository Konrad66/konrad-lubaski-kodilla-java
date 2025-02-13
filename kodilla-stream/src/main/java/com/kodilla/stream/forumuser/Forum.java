package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1, "Konrad", 'M', LocalDate.of(1998, 11, 20), 6));
        usersList.add(new ForumUser(2, "Wiktoria", 'F', LocalDate.of(2002, 1, 24), 5));
        usersList.add(new ForumUser(3, "Beata", 'F', LocalDate.of(1980, 10, 4), 0));
        usersList.add(new ForumUser(4, "Przemyslaw", 'M', LocalDate.of(1985, 6, 16), 10));
        usersList.add(new ForumUser(5, "Aaron", 'M', LocalDate.of(2017, 1, 26), 0));
        usersList.add(new ForumUser(6, "Katarzyna", 'F', LocalDate.of(1999, 5, 27), 3));
        usersList.add(new ForumUser(7, "Roman", 'M', LocalDate.of(1997, 7, 7), 7));
        usersList.add(new ForumUser(8, "Roman", 'M', LocalDate.of(1990, 8, 8), 0));
        usersList.add(new ForumUser(9, "Ola", 'F', LocalDate.of(2003, 10, 8), 1));
        usersList.add(new ForumUser(10, "Artur", 'M', LocalDate.of(2008, 1, 12), 4));
    }

    public List<ForumUser> getUsersList() {
        return new ArrayList<>(usersList);
    }
}
