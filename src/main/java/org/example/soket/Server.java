package org.example.soket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        startServer();

    }

    private static void startServer() throws Exception{
        try (
                ServerSocket server = new ServerSocket(8080);
                Socket socket = server.accept();

        ){
            InputStream is = socket.getInputStream();

            byte[] input = new byte[100];
            int length = is.read(input);

            String inputData = new String(input, 0, length);

            System.out.println("From client:"+ inputData);

            OutputStream os = socket.getOutputStream();
            os.write("OK".getBytes());
            os.flush();
        }
    }
}
