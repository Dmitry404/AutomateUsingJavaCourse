package com.javacourses.homework1;

import java.util.Arrays;

public class WebBlogNavigation extends WebBlog {

    private String location = "/main";
    private String[] categories = { "/main", "/politics", "/economics", "/society" };
    public WebBlogNavigation() {}

    public String[] getCategoriesRaw() {
        return categories;
    }

    protected String getLocation() {
        System.out.println(classname() + "Current location - " + blogURL + this.location);
        return this.location;
    }

    public void getCategories() {
        System.out.println(classname() + "Available categories - " + Arrays.toString(categories));
    }

    public void navigateTo(String category) {
        this.location = category;
        System.out.println(classname() + "We just moved to " + blogURL + location);
    }

    public void search(String searchKeyword) {
        System.out.println(classname() + "Let's search \"" + searchKeyword + "\"...");
        searchKeyword = searchKeyword.replaceAll("\\s+", "%2F");
        navigateTo("/search?keyword=" + searchKeyword);
    }

    public void clickExternalLink(String externalLinkURL) {
        System.out.println(classname() + "External link opened");
        navigateTo("/away.php=" + externalLinkURL);
    }

}
