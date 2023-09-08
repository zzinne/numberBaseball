package org.example.http;

import com.google.common.base.Strings;
import org.example.util.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class RequestParam{
    private Map<String, String> params = new HashMap<>();

    public void putParam(String data){
        if(Strings.isNullOrEmpty(data)){
            return;
        }
        params.putAll(HttpUtils.parseQueryString(data));
    }

    public void addQueryString(String data){
        putParam(data);
    }
    public void addBody(String body){
        putParam(body);
    }
    public String getParameter(String key){
        return params.get(key);
    }
}
