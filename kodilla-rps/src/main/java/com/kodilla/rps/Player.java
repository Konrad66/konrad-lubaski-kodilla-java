package com.kodilla.rps;

public abstract class Player {

    String name;
    int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public abstract Move move();

    public void increaseScore() {
        score++;
    }
}