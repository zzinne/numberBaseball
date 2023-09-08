package org.example.dao;

import org.example.Game;
import org.example.db.NumberBaseBallDb;

public class NumberBaseBallDao {

    public void insertDb(String key, Game value){
        NumberBaseBallDb.memDb.put(key,value);
    }
    public Game selectDb(String key){
        return NumberBaseBallDb.memDb.get(key);
    }

}
