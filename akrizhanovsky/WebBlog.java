package com.javacourses.homework1;

import java.util.Arrays;

abstract public class WebBlog {

    protected final String blogURL = "http://xander.myfirstblog.lohika.com";
    protected final String blogName = "First Blog";
    protected final String blogEngine = "WordPress";
    protected static String loggedAsUser;
    protected static int postId = 0;
    protected static int attachId = 0;
    protected static int commentId = 0;
    public WebBlog() {}

    public static void main(String ... args) {

        WebBlogNavigation webBlogNavigation = new WebBlogNavigation();
        WebBlogAuth webBlogAuth = new WebBlogAuth(); // related to webBlog
        WebBlogProfile webBlogProfile = new WebBlogProfile(); // related to webBlog
        WebBlogPost webBlogPost = new WebBlogPost(); // related to webBlog. optionally - clarify postId
        WebBlogAttachment webBlogAttachment = new WebBlogAttachment(); // related to WebBlog, optionally related to WebBlogParentComment
        WebBlogComment webBlogComment = new WebBlogComment(); // related to WebBlog, optionally related to WebBlogParentComment

        WebBlogAdminCategories webBlogAdminCategories = new WebBlogAdminCategories();
        WebBlogAdminUsers webBlogAdminUsers = new WebBlogAdminUsers();
        // TODO WebBlogAdmin* classes are dummy

        WebBlogUtils webBlogUtils = new WebBlogUtils();

        // WebBlog Authorization class
        loggedAsUser = webBlogAuth.getAuthInfo();
        webBlogAuth.register("xander", "qweqwe", "alex.ks02@gmail.com");
        webBlogAuth.login("xander", "qweqwe");
        loggedAsUser = webBlogAuth.getAuthInfo();
        System.out.println();

        // WebBlog Profile class
        webBlogProfile.openProfile(loggedAsUser, 1337);
        webBlogProfile.openEditProfileForm(loggedAsUser);
        webBlogProfile.editProfile(loggedAsUser, "zxczxc", "blabla@gmail.com", "U1RVVldYWVpjZGVmZ2hpanN0dXZ ... etc");
        webBlogProfile.submitProfile(loggedAsUser);
        System.out.println();

        // WebBlog Navigation class
        webBlogNavigation.search("Putin Huilo");
        webBlogNavigation.clickExternalLink("http://blackhole.com");
        webBlogNavigation.navigateTo("/main");
        webBlogNavigation.getLocation();
        webBlogNavigation.getCategories();
        webBlogNavigation.navigateTo(webBlogUtils.getRandomStringArrayItem(webBlogNavigation.getCategoriesRaw()));
        System.out.println();

        // WebBlog Post and Attachment class
        webBlogPost.listPosts(webBlogNavigation.getLocation());
        postId = webBlogPost.newPost("My first post", "Hello there!", "/main", Arrays.asList("боль", "унижение", "вечные муки"));
        attachId = webBlogAttachment.add(postId, 0, "audio", "p6ipqrKztLW2t7i5usLDxMXGx8j ... etc");
        webBlogPost.submitPost(); webBlogPost.displayLatestPost();
        commentId = webBlogComment.newComment(postId, 0, "What the fuck?");
        webBlogComment.submitCommentForm(commentId);
        webBlogComment.editComment(commentId, "Sorry, I'm wrong..");
        webBlogAttachment.add(0, commentId, "image", "AwEBAQEBAQEBAQAAAAAAAAECAwQ ... etc");
        webBlogComment.submitCommentForm(commentId);
        webBlogComment.deleteComment(commentId);
        webBlogPost.editPost("My fisrt post (edited)", "Bite my shiny metal ass!", "/culture", Arrays.asList("КТОЗДЕСЬ?!"));
        webBlogAttachment.delete(postId, attachId);
        webBlogAttachment.add(postId, 0, "image", "/9j/4AAQSkZJRgABAgEAYABgAAD ... etc");
        webBlogPost.submitPost(); webBlogPost.displayLatestPost();
        webBlogPost.deleteLatestPost();
        System.out.println();

        // Logout
        webBlogAuth.logout();

    }

    public String classname() {
        return this.getClass().getSimpleName() + " class: ";
    }

}
