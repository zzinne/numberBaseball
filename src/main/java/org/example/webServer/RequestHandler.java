package org.example.webServer;

import org.example.Game;
import org.example.Player;
import org.example.Referee;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestHandler extends Thread{
    private Socket connection;

    public RequestHandler(Socket connection){
        this.connection = connection;
    }

    @Override
    public void run() {
        try(
                InputStream in = connection.getInputStream();
                OutputStream out = connection.getOutputStream()
        ){
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

            Map<String, String> header  = new HashMap<>();

            String line = br.readLine();
            String data = "";

            int contentLength = 0;

            String[] tokens = line.split(" ");
            String url = tokens[1];

            while (!(line = br.readLine()).equals("")){
                System.out.println(line);
                String[] splitString = line.split(":");
                String headerData = splitString[1].trim();
                if (splitString[0].equals("Content-Length")){
                    contentLength = Integer.parseInt(headerData);
                }
                header.put(splitString[0],headerData);
            }

            String cookie[] = header.get("Cookie").split(";");
            Map<String,String> cookieMap = Arrays.stream(cookie)
                                                 .map(t->new Pair(t.split("=")[0], t.split("=")[1]))
                                                 .collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));

            if (contentLength != 0){
                char[] body = new char[contentLength];
                br.read(body,0,contentLength);
                data = String.valueOf(body);
                String[] dataSplit = data.split("=");
                data = dataSplit[1].trim();

            }
            if ("/".equals(url)){

                DataOutputStream dos = new DataOutputStream(out);
                byte[] body = Files.readAllBytes(new File("src/main/webapp/index.html").toPath());
                dos.writeBytes("HTTP/1.1 200 OK \r\n");
                dos.writeBytes("Content-Type: text/html;charset=utf-8 \r\n");
                dos.writeBytes("Content-Length: "+ body.length+"\r\n");
                dos.writeBytes("\r\n");
                dos.write(body,0,body.length);
                dos.flush();

            }
            if ("/gameStart".equals(url)){

                DataOutputStream dos = new DataOutputStream(out);
                byte[] body = Files.readAllBytes(new File("src/main/webapp/gameStart.html").toPath());
                dos.writeBytes("HTTP/1.1 200 OK \r\n");
                dos.writeBytes("Content-Type: text/html;charset=utf-8 \r\n");
                dos.writeBytes("Content-Length: "+ body.length+"\r\n");
                dos.writeBytes("Set-Cookie: sessionId="+data+"\r\n");
                dos.writeBytes("\r\n");
                dos.write(body,0,body.length);
                dos.flush();

            }
            if ("/checkResult".equals(url)){

                String htmlString = "<!DOCTYPE html>"+
                        "<html lang='en'>"+
                        "<head>"+
                        "<meta charset='UTF-8'>"+
                        "<title>Title</title>"+
                        "</head>"+
                        "<body>"+
                        "<div>" +
                        "<b>숫자 야구</b> <br>" +
                        "결과 :"+
                        "</div>"+
                        "</body>"+
                        "</html>";


                DataOutputStream dos = new DataOutputStream(out);
                byte[] body = htmlString.getBytes();
                dos.writeBytes("HTTP/1.1 200 OK \r\n");
                dos.writeBytes("Content-Type: text/html;charset=utf-8 \r\n");
                dos.writeBytes("Content-Length: "+ body.length+"\r\n");
                dos.writeBytes("\r\n");
                dos.write(body,0,body.length);
                dos.flush();

            }


         }catch (IOException e){

        }

    }
public static class Pair{
        String key;
        String value;
    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

}
