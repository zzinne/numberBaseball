package org.example.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpRequest {
    private String line = "";
    private HttpHeader httpHeader ;
    private RequestLine requestLine;
    private RequestParam requestParam;
    private String path;

    public HttpRequest(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        this.httpHeader = processHeaders(br);
    }
    private HttpHeader processHeaders(BufferedReader br) throws IOException {
        HttpHeader httpHeader = new HttpHeader();
        String line;
        while (!(line = br.readLine()).equals("")){
            httpHeader.add(line);
        }
        return httpHeader;
    }
    public String createReadLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        if (line == null){
            throw new IllegalStateException();
        }
        return line ;
    }
    public String getPath(){
        return requestLine.getPath();
    }

}
