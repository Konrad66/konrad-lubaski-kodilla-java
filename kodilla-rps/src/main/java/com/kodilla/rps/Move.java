package com.kodilla.rps;

public enum Move {

    ROCK, PAPER, SCISSORS;

    public boolean beats(Move other) {
        return (this == ROCK && other == SCISSORS) ||
                (this == SCISSORS && other == PAPER) ||
                (this == PAPER && other == ROCK);
    }
}