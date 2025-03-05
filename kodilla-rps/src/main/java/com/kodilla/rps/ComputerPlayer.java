package com.kodilla.rps;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Move move() {
        Random rand = new Random();
        int computerMove = rand.nextInt(3) + 1;
        switch (computerMove) {
            case 1:
                return Move.ROCK;
            case 2:
                return Move.PAPER;
            case 3:
                return Move.SCISSORS;
            default:
                System.out.println("Wrong computer move");
        }
        return null;
    }
}