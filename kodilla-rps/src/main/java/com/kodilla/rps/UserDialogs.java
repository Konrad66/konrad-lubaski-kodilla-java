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
        int rounds;
        System.out.println("Enter how many rounds you would like to play: ");
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                rounds = Integer.parseInt(input);
                if (rounds > 0) {
                    return rounds;
                } else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number greater than 0.");
            }
        }
    }

    //todo obsługiwać dwa pozostałem przypadki jakom move w enum
    public static Move getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Choose a move (ROCK - 1, PAPER - 2, SCISSORS - 3) or 'X' to quit the game, 'N' to start new game");

        while (true) {
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("X")) {
                System.out.println("Thanks for playing! See you soon!");
                return Move.X;
            }

            if (input.equals("N")) {
                return Move.N;
            }

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        return Move.ROCK;
                    case 2:
                        return Move.PAPER;
                    case 3:
                        return Move.SCISSORS;
                    default:
                        System.out.println("Invalid input.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number (1-3) or 'X' to quit, 'N' to restart.");
            }
        }
    }
}