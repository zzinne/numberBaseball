package org.example.webServer;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) throws Exception {
        start();
    }

    private static void start() throws Exception{
        try(
                ServerSocket server = new ServerSocket(8080);

                ) {
            Socket connection;
            while ((connection = server.accept()) != null){
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
        }
    }

}
