package org.example.service;

import org.example.Game;
import org.example.dao.NumberBaseBallDao;

public class GameService {
    NumberBaseBallDao dao ;

    public GameService() {
        this.dao = new NumberBaseBallDao();
    }

    public void createGame(String id){
        Game game = new Game();
        game.start();
        this.dao.insertDb(id,game);
    }

    public Boolean checkCount(String id){
        Game game = this.dao.selectDb(id);
        return game.count.isCountOver();
    }

    public boolean checkResult(String id){
        Game game = this.dao.selectDb(id);
        return game.count.isCountOver();

    }

}
