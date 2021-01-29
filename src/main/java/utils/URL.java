package main.java.utils;

public class URL {

    public static final String URL = "https://restful-booker.herokuapp.com/";

    public static String getEndpoint() {
        return URL;
    }

    public static String getEndpoint(String resource) {
        return URL + resource;
    }
}
