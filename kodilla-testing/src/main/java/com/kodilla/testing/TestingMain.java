package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        Calculator calculator = new Calculator();

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test ok");
        } else {
            System.out.println("test fail");
        }


        int addResult = calculator.add(1, 2);
        int subResult = calculator.subtract(3, 4);

        System.out.println("Test dla dodawania");
        if (addResult == 3) {
            System.out.println("test ok");
        } else {
            System.out.println("test fail");
        }

        System.out.println("Test dla odejmowania");
        if (subResult == -1) {
            System.out.println("test ok");
        } else {
            System.out.println("test fail");
        }
    }
}
