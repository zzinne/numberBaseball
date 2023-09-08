package org.example.controller;

import org.example.http.HttpRequest;
import org.example.http.HttpResponse;

import java.io.IOException;

public interface Controller {

    void service(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException;


}
