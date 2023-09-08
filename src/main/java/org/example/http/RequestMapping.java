package org.example.http;

import org.example.controller.Controller;
import org.example.controller.GameController;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<>();

    static {
         controllers.put("/gameStart", new GameController());
    }

    public static Controller getController(String path){
        return controllers.get(path);
    }

}
