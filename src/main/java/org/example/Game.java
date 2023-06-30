package org.example;

import java.util.*;

public class Game {
    private Referee referee ;

    public void start(){
        Rule rule = new Rule();
        Player player = new Player();
        Count count = new Count();
        count.askCountOver();
        this.referee = new Referee(rule);
        referee.setResult(Result.makeResult());
        referee.playGame(count);
    }
}
