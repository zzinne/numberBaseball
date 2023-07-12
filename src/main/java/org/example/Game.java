package org.example;

import java.util.*;

public class Game {
    private Referee referee ;
    private Rule rule = new Rule();

    private Count count = new Count();
    private Player player ;

    public Game() {
        this.referee = new Referee(this.rule);
        this.player = new Player();
        this.referee.setResult(Result.makeResult());
    }

    public void start(){
        this.count.askCountOver();
        this.referee.playGame(this.count, this.player);
    }
}
