package org.example;

import java.util.*;

public class Game {
    private final Referee referee ;

    public Game() {
        this.referee = new Referee();
        referee.playGame();

    }
}
