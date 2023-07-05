package org.example;

import java.util.*;

public class Game {
    private Referee referee ;

    public void start(){
        Rule rule = new Rule();
        Count count = new Count();
        Player player = new Player();
        count.askCountOver();
        this.referee = new Referee(rule);
        referee.setResult(Result.makeResult());
        referee.playGame(count, player);
    }
}
