package com.javacourses.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebBlogPost extends WebBlogNavigation {

    private int postId;
    private String title = "";
    private String body = "";
    private String category = "";
    private List<String> tags = new ArrayList<String>();
    private String[] postList = { "Main news #1", "Main news #2", "Main news #3" };
    public WebBlogPost() {}
    WebBlogUtils webBlogUtils = new WebBlogUtils();

    public void listPosts(String location) {
        //TODO Спросить насчёт https://docs.oracle.com/javase/7/docs/technotes/guides/language/strings-switch.html
        //String testString = "/main";


        switch (location) {
            case "/main":
                this.postList = new String[] {"Main news #1", "Main news #2", "Main news #3"};
                break;
            case "/politics":
                this.postList = new String[] {"Politic news #1", "Politic news #2", "Politic news #3"};
                break;
            case "/econimics":
                this.postList = new String[] {"Economics news #1", "Economics news #2", "Economics news #3"};
                break;
            case "/society":
                this.postList = new String[] {"Society news #1", "Society news #2", "Society news #3"};
                break;
        }
        System.out.println(classname() + "Posts list: " + Arrays.toString(postList));

        //System.out.println(classname() + "Post list (temporary static) - " + Arrays.toString(postList));
    }

    public int newPost(String title, String body, String category, List<String> tags) {
        if (!loggedAsUser.isEmpty()) {
            this.title = title; this.body = body; this.category = category; this.tags = tags; this.postId = webBlogUtils.createPostId();
            System.out.println(classname() + "New post form opened");
            return postId;
        } else {
            System.out.println(classname() + "ERROR - You aren't logged in");
            return postId;
        }
    }

    public void displayLatestPost() {
        if (!loggedAsUser.isEmpty()) System.out.println(classname() + "Latest created/edited post: id = \"" + postId + "\", title = \"" + title + "\", body = \"" + body + "\", category = \"" + category + "\", tags = \"" + tags + "\"");
    }

    public void editPost(String title, String body, String category, List<String> tags) {
        if (!loggedAsUser.isEmpty()) {
            this.title = title; this.body = body; this.category = category; this.tags = tags;
            System.out.println(classname() + "Edit post form opened");
        } else {
            System.out.println(classname() + "ERROR - You aren't logged in");
        }
    }

    public void deleteLatestPost() {
        if (!loggedAsUser.isEmpty()) {
            this.title = ""; this.body = ""; this.category = ""; this.tags = new ArrayList<String>(); postId = 0;
            System.out.println(classname() + "Post was deleted");
        } else {
            System.out.println(classname() + "ERROR - You aren't logged in");
        }
    }

    public void submitPost() {
        if (postId != 0) System.out.println(classname() + "Post was saved successfully");
    }

}
