package com.kodilla.rps;

public class GameService {

    public void startProgram() {
        String playerName = UserDialogs.getPlayerName();
        System.out.println("Hello " + playerName + ", welcome to rock-paper-scissors game!");
        howToPlay();
        int numberOfRounds = UserDialogs.getNumberOfRounds();

        Player computerPlayer = new ComputerPlayer("Computer");
        Player player1 = new HumanPlayer(playerName);
        while (true) {
            Move playerMove = player1.move();
            Move computerMove = computerPlayer.move();

            System.out.println(playerMove);
            System.out.println(computerMove);

            String determineWinner = determineWinner(playerMove, computerMove, player1, computerPlayer);
            System.out.println(determineWinner);

            if (player1.getScore() == numberOfRounds) {
                System.out.println(player1.getName() + " wins!");
                break;
            } else if (computerPlayer.getScore() == numberOfRounds) {
                System.out.println(computerPlayer.getName() + " wins!");
                break;
            }
            String choice = UserDialogs.getPlayerChoice();
            if (choice.equals("N")) {
                startProgram();
            } else if (choice.equals("X")) {
                System.out.println("Thanks for playing! See you soon!");
                System.exit(0);
            }
        }
    }

    public void howToPlay() {
        System.out.println("Before you start the game, read below instructions, how to play!");
        System.out.println("Rock, Paper, Scissors is a simple game for two players. Each player chooses one of three options: Rock, Paper, or Scissors. The winner is determined as follows:\n" +
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

    private String determineWinner(Move playerMove, Move computerMove, Player player1, Player player2) {
        if (playerMove == computerMove) {
            return "Draw!";
        }
        if (playerMove.beats(computerMove)) {
            player1.increaseScore();
            return player1.getName() + " wins this round!";
        } else {
            player2.increaseScore();
            return player2.getName() + " wins this round!";
        }
    }
}