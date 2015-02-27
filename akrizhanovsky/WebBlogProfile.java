package com.javacourses.homework1;

public class WebBlogProfile extends WebBlog {

    private int userId;
    private String password;
    private String email;
    private String avatar_base64;
    public WebBlogProfile() {}

    public void openProfile(String loggedAsUser, int userId) {
        if (!loggedAsUser.isEmpty()) {
            System.out.println(classname() + "Opening profile with userid=" + userId);
        } else {
            System.out.println(classname() + "Please log in first");
        }
    }
    public void openEditProfileForm(String loggedAsUser) {
        if (!loggedAsUser.isEmpty()) {
            System.out.println(classname() + "Opening your profile for edit");
        } else {
            System.out.println(classname() + "Please log in first");
        }
    }
    public void editProfile(String loggedAsUser, String password, String email, String avatar_base64) {
        if (!loggedAsUser.isEmpty()) {
            System.out.println(classname() + "Editing your profile. New password = \"" + password + "\", new email is \"" + email + "\", new avatar also set successfully");
        } else {
            System.out.println(classname() + "Please log in first");
        }
    }

    public void submitProfile(String loggedAsUser) {
        System.out.println(classname() + "Sumbit your profile with name=" + loggedAsUser);
    }

}
