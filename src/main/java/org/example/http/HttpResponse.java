package org.example.http;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpResponse {
    private DataOutputStream dos = null;

    private HttpHeader httpHeader;
    private Map<String,String> headers = new HashMap<>();

    public HttpResponse(OutputStream out) {
        this.dos = new DataOutputStream(out);
    }
    void responseBody(byte[] body) throws IOException {
        dos.write(body,0,body.length);
        dos.writeBytes("\r\n");
        dos.flush();
    }
    private void response200Header() throws IOException {
        dos.writeBytes("HTTP/1.1 200 OK \r\n");
        processHeaders();
        dos.writeBytes("\r\n");
    }
    public void addHeader(String key, String value){
        this.headers.put(key,value);
    }
    public void processHeaders() throws IOException {
        Set<String> keys = headers.keySet();
        for (String key : keys){
            dos.writeBytes(key+": "+this.headers.get(key)+"\r\n");
        }
    }
    public void forward(String path) throws IOException {

        byte[] body = Files.readAllBytes(new File("src/main/webapp/"+path+".html").toPath());
        this.headers.put("Content-Type","text/html;charset="+ StandardCharsets.UTF_8);
        this.headers.put("Content-Length",body.length+"");
        response200Header();
        responseBody(body);
    }
    public void forwardBody(String body) throws IOException {

        byte[] contents = body.getBytes();
        this.headers.put("Content-Type","text/html;charset="+ StandardCharsets.UTF_8);
        this.headers.put("Content-Length",contents.length+"");
        response200Header();
        responseBody(contents);
    }
}
