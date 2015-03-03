package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog;

public class RunTest {
    public static final String[][] USERS;
    public static final String[] REGULAR_PAGES;
    public static final String[] URL_PAGES;
    public static final String spacer = "=====================================================================================================";
    public static final String spacer_small = "==================================";

    static {
        USERS = new String[][]{
                {"vasya", "1"},
                {"root", "0"},
                {"guest_user", "3"},
                {"vasya", "0" },
                {"vasya", "1" },
                {"stas", "100" },
                {"aaa", "-100" },
        };
        REGULAR_PAGES = new String[]{
                "The 1st page",
                "The 2nd page",
                "The 3rd page",
                "The 4th page",
                "The 5th page",
        };

        URL_PAGES = new String[]{
                "http://server1.hp.com/index.php",
                "http://server2.hp.com/index.php",
                "http://server3.hp.com/index.php",
        };


    }


    public static void main(String[] args) {
        System.out.println(spacer);
        System.out.println("Create a new web blog");
        System.out.println(spacer_small);
        WebBlog blog = new WebBlog();

        System.out.println(spacer);
        System.out.println("Add users in the blog");
        System.out.println(spacer_small);
        for (int i = 0; i < USERS.length; i++) {
            System.out.println(USERS[i][0] + "    " + USERS[i][1]);
            blog.addUser(USERS[i][0], Integer.parseInt(USERS[i][1]));
        }

        System.out.println(spacer);
        System.out.println("Show All users");
        System.out.println(spacer_small);
        blog.showAllUsers();

        System.out.println(spacer);
        System.out.println("Set the root as active user");
        System.out.println(spacer_small);
        blog.setActiveUser(2);

        System.out.println(spacer);
        System.out.println("Add regular pages");
        System.out.println(spacer_small);
        for (String page : REGULAR_PAGES) {
            blog.AddNewRegularPage(page);
        }

        System.out.println(spacer);
        System.out.println("Set the vasya as active user");
        System.out.println(spacer_small);
        blog.setActiveUser(1);

        System.out.println(spacer);
        System.out.println("Try to add pages as user vasya");
        System.out.println(spacer_small);
        for (String page : URL_PAGES) {
            blog.AddNewUrlPage(page);
        }

        System.out.println(spacer);
        System.out.println("Try to add pages as user root");
        blog.setActiveUser(2);
        System.out.println(spacer_small);
        for (String page : URL_PAGES) {
            blog.AddNewUrlPage(page);
        }

        System.out.println(spacer);
        System.out.println("Show all pages");
        System.out.println(spacer_small);
        blog.displayAllPages();

        System.out.println(spacer);
        System.out.println("Try to show non-existed page");
        System.out.println(spacer_small);
        blog.displayPage(1000);
    }
}