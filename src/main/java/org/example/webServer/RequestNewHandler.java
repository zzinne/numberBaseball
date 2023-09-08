package org.example.webServer;

import org.example.controller.Controller;
import org.example.http.HttpRequest;
import org.example.http.HttpResponse;
import org.example.http.RequestLine;
import org.example.http.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestNewHandler extends Thread{
    private Socket connection;

    public RequestNewHandler(Socket connection){
        this.connection = connection;
    }
    @Override
    public void run() {
        try(
                InputStream in = connection.getInputStream();
                OutputStream out = connection.getOutputStream()
        ){
            HttpRequest httpRequest  = new HttpRequest(in);
            HttpResponse httpResponse = new HttpResponse(out);
            String path = getDefaultPath(httpRequest.getPath());
            Controller controller = RequestMapping.getController(path);
            controller.service(httpRequest, httpResponse);


        } catch (IOException e) {

        }
    }

    private String getDefaultPath(String path){
        if("/".equals(path)){
            return "src/main/webapp/index.html";
        }
        return path;
    }
}
