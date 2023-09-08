package org.example.controller;

import org.example.http.HttpRequest;
import org.example.http.HttpResponse;

import java.io.IOException;

public class GameController implements Controller{

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        //TODO: 게임시작 로직 추가

        httpResponse.forward(httpRequest.getPath());
    }
}
