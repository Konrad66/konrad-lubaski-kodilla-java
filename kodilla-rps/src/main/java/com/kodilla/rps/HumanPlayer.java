package com.kodilla.rps;


public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Move move() {
        return UserDialogs.getPlayerChoice();
    }
}