package org.example.http;

import java.util.HashMap;
import java.util.Map;

public class HttpHeader {
    private static final String CONTENT_LENGTH = "Content-Length";
    private Map<String, String> headers = new HashMap<>();

   public int getContentLength(){
       return Integer.parseInt(getHeader(CONTENT_LENGTH));
   }
   public String getHeader(String key){
       return this.headers.get(key);
   }
   public void add(String data){
       String[] splitedHeader = data.split(":");
       headers.put(splitedHeader[0],splitedHeader[1].trim());
   }

}
