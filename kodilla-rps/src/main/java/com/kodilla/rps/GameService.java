package com.kodilla.rps;

import java.util.Optional;

public class GameService {

    public void startProgram() {
        String playerName = UserDialogs.getPlayerName();
        UserDialogs.welcome(playerName);
        UserDialogs.howToPlay();
        int numberOfRounds = UserDialogs.getNumberOfRounds();

        Player computerPlayer = new ComputerPlayer("Computer");
        Player humanPlayer = new HumanPlayer(playerName);

        while (true) {
            Move humanMove = humanPlayer.move();
            if (humanMove == Move.X) {
                System.exit(0);
            } else if (humanMove == Move.N) {
                startProgram();
            }
            Move computerMove = computerPlayer.move();


            UserDialogs.gameStatus(humanPlayer, humanMove);
            UserDialogs.gameStatus(computerPlayer, computerMove);

            Player winner = determineWinner(humanMove, computerMove, humanPlayer, computerPlayer);
            if (winner != null) {
                System.out.println(winner);
            } else {
                System.out.println("It's a draw!");
            }

            Optional.ofNullable(winner).ifPresent(Player::increaseScore);

            if (humanPlayer.getScore() == numberOfRounds) {
                System.out.println(humanPlayer.getName() + " wins!");
                break;
            } else if (computerPlayer.getScore() == numberOfRounds) {
                System.out.println(computerPlayer.getName() + " wins!");
                break;
            }

            System.out.println(humanPlayer.getName() + " " + humanPlayer.getScore() + " : " + computerPlayer.getScore() + " " + computerPlayer.getName());
        }
    }

    private Player determineWinner(Move playerMove, Move computerMove, Player player1, Player player2) {
        if (playerMove == computerMove) {
            System.out.println("Draw!");
            return null;
        }
        if (playerMove.beats(computerMove)) {
            System.out.println(UserDialogs.roundWinner(player1));
            return player1;
        } else {
            System.out.println(UserDialogs.roundWinner(player2));
            return player2;
        }
    }
}