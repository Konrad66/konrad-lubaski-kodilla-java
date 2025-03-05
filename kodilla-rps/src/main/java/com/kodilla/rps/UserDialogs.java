package com.kodilla.rps;

import java.util.Scanner;

public class UserDialogs {

    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    public static int getNumberOfRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many rounds you want to play: ");
        return scanner.nextInt();
    }

    public static int getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a move (ROCK - 1, PAPER - 2, SCISSORS - 3)");
        return scanner.nextInt();
    }

    public static String getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 'N' to start a new game or 'X' to quit");
        return scanner.nextLine();
    }
}