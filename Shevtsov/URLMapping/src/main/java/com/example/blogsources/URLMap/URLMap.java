package com.example.blogsources.URLMap;

public class URLMap {
    public static final String PROTO = "http://";
    public static final String HOST = "localhost";
    public static final String PORT = ":8080/";
    public static final String CONTEXT = "demo";
    public static final String FULL_URL = PROTO + HOST + PORT + CONTEXT;
    public static final String LOGIN = "/login";
    public static final String FULL_LOGIN = FULL_URL + LOGIN;
    public static final String LOGOUT = "/logout";
    public static final String FULL_LOGOUT = FULL_URL + LOGOUT;
    public static final String REGISTER = "/register";
    public static final String FULL_REGISTER = FULL_URL + REGISTER;
    public static final String ADDPOST = "/addPost";
    public static final String FULL_ADDPOST = FULL_URL + ADDPOST;
    public static final String WELCOME = "/welcome";
    public static final String FULL_WELCOME = FULL_URL + WELCOME;
    public static final String ABOUT = "/about";
    public static final String FULL_ABOUT = FULL_URL + ABOUT;
}
