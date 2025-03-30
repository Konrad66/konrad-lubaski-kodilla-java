package com.kodilla.rps;

public class UserOutput {

    static void welcome(String playerName) {
        System.out.println("Hello " + playerName + ", welcome to rock-paper-scissors game!");
    }

    static void gameStatus(Player player, Move move) {
        System.out.println(move + ": " + player.getName());
    }

    static String roundWinner(Player player) {
        return player.getName() + " wins this round!";
    }

    static void howToPlay() {
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

    public static void restartedGame() {
        System.out.println("Game restarted!");
    }
}
