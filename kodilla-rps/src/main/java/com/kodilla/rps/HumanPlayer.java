package com.kodilla.rps;


public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Move move() {
        int userChoice;
        do {
            userChoice = UserDialogs.getPlayerMove();
        } while (userChoice < 1 || userChoice > 3);
        switch (userChoice) {
            case 1:
                return Move.ROCK;
            case 2:
                return Move.PAPER;
            case 3:
                return Move.SCISSORS;
            default:
                System.out.println("Invalid move. Choose number between 1 and 3");
        }
        return null;
    }
}