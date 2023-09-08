package org.example;

import java.util.*;

public class Game {
    private Referee referee ;
    private Rule rule = new Rule();

    public Count count = new Count();
    private Player player ;

    public Game() {
        this.referee = new Referee(this.rule);
        this.player = new Player();
        this.referee.setResult(Result.makeResult());
    }

    public void start(){
        this.count.setOverCount(6);
        this.referee.playGame(this.count, this.player);
    }

    public Player getPlayer() {
        return player;
    }

    public Referee getReferee() {
        return referee;
    }
}
