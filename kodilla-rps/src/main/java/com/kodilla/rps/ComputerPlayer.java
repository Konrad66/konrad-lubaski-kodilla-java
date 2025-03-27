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
        return switch (computerMove) {
            case 1 -> Move.ROCK;
            case 2 -> Move.PAPER;
            case 3 -> Move.SCISSORS;
            default -> null;
        };
    }
}