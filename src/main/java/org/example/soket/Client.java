package org.example.soket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception{
        connect();
    }

    private static void connect() throws Exception{
        try(Socket socket = new Socket("127.0.0.1", 8080)) {

            OutputStream out = socket.getOutputStream();
            String outMsg = "Mung";
            out.write(outMsg.getBytes());
            out.flush();

            InputStream in = socket.getInputStream();
            byte[] input = new byte[100];
            int length = in.read(input);
            String inputData = new String(input,0,length);

            System.out.println("From Server :"+inputData);
        }
    }
}
