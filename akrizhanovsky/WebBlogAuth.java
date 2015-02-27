package com.javacourses.homework1;

public class WebBlogAuth extends WebBlog {

    //private userId;
    private String loggedAsUser = "";
    private String username = "";
    private String password = "";
    private String email = "";
    public WebBlogAuth() {}

    public String getAuthInfo() {
        if (loggedAsUser.isEmpty()) {
            System.out.println(classname() + "You are not logged in");
            return "";
        } else {
            System.out.println(classname() + "You are logged as " + loggedAsUser);
            return loggedAsUser;
        }
    }

    public void register(String username, String password, String email) {
        this.username = username; this.password = password; this.email = email;
    }

    public void login(String username, String password) {
        if (this.username == username && this.password == password) {
            this.loggedAsUser = username;
            System.out.println(classname() + "Login was successful");
        }
    }
    public void logout() {
        this.loggedAsUser = "";
        System.out.println(classname() + "Logout was successful");
    }

}
