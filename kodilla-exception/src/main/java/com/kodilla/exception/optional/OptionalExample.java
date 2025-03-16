package com.kodilla.exception.optional;

import com.kodilla.exception.nullpointer.User;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        User user = new User("User");
        Optional<User> optionalUser = Optional.ofNullable(user);

        optionalUser.ifPresent(u-> System.out.println(u.getName()));

        String userName = optionalUser.orElse(new User("")).getName();
        System.out.println(userName);
    }


}
