package org.example.http;

public class RequestLine {
    private HttpMethod httpMethod;
    private String path = "";
    private String queryString;

    public RequestLine(String line) {

        String[] tokens = line.split(" ");

        this.httpMethod = HttpMethod.valueOf(tokens[0]);

        String[] url = tokens[1].split("\\?");
        this.path = url[0];
        this.queryString = url[1];

    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getPath() {
        return path;
    }

    public String getQueryString() {
        return queryString;
    }
}
