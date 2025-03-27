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

    public static void welcome(String playerName) {
        System.out.println("Hello " + playerName + ", welcome to rock-paper-scissors game!");
    }

    public static void gameStatus(Player player, Move move) {
        System.out.println(move + ": " + player.getName());
    }

    public static String roundWinner(Player player) {
        return player.getName() + " wins this round!";
    }

    public static void howToPlay() {
        System.out.println("Before you start the game, read below instructions, how to play!");
        System.out.println("Rock, Paper, Scissors is a simple game for two players. \n" +
                "Each player chooses one of three options: Rock, Paper, or Scissors. \n" +
                "The winner is determined as follows:\n" +
                "Rock beats Scissors (Rock crushes Scissors)\n" +
                "Scissors beats Paper (Scissors cut Paper)\n" +
                "Paper beats Rock (Paper wraps Rock)\n" +
                "If both players choose the same option, it is a tie.\n" +
                "Game Controls\n" +
                "Press 1 - Play Rock\n" +
                "Press 2 - Play Paper\n" +
                "Press 3 - Play Scissors\n" +
                "Press X - Exit the game\n" +
                "Press N - Restart the game");
    }
}