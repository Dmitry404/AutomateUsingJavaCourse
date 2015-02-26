package AutomateUsingJava.lesson1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WebBlog {

    protected static String webBlogName = "Homework #1 & #2. Team work: Lesha, Artem, Viktor";
    protected static String legend = "1 - show Posts, 2 - login, 3 - add post, 4 - add user, 5 - add comment, 6 - make admin, 7 - exit";
    public static Post [] blogPosts = new Post [10];
    int postId = 0;
    public static Users [] blogUser = new Users [10];
    int userId =0;
    int curUserId=-1;
    public static BufferedReader readit = new BufferedReader(new InputStreamReader(System.in));

    public void addPost2Blog (Post p) {

        if (postId < blogPosts.length) {
            blogPosts[postId] = p;
            postId++;}
        else System.out.println("ERROR: This nice blog is designed to contain no more than " + blogPosts.length + " posts! Please stop adding the content");
    }

    public void showPosts4Blog () {
        //for (each Comments a : postComments
        for (int i=0; i< postId; i++) {
            System.out.println("");
            System.out.println("#" + i + " " + blogPosts[i].getPostName() + " created by: " + blogPosts[i].getPostAuthor() + " at " + blogPosts[i].getPostDate());
            System.out.println(blogPosts[i].getPostContent());
            blogPosts[i].showComments2Post();
            System.out.println("");
        }
    }

    public void addUser(Users u) {
        if (userId < blogUser.length) {
            blogUser[userId] = u;
            userId++;
        }
        else System.out.println("ERROR: You reached the limit for maximum users of this nice blog! The current limit is: " + blogUser.length);
    }


    public void login (String l, String p){
        for (int i = 0; i < WebBlog.blogUser.length; i++) {
//            System.out.println(WebBlog.blogUser.length + " , i: " + i);                            //for test purposes
//            System.out.println(WebBlog.blogUser[i].getUserName() + " " + WebBlog.blogUser[i].getUserPassword());              //for test purposes
            if (WebBlog.blogUser[i] == null) break;
//            try {
            if (blogUser[i].getUserName().equals(l)) {
                if (blogUser[i].getUserPassword().equals(p)) {
                    System.out.println("Welcome " + l + " id: " + i);
                    curUserId = i;
                    break;
                }
            }
//            }
//            catch (NullPointerException e) {
//
//            }
        }
    }

    public boolean action (int a) throws IOException {
        // 1 - show Posts, 2 - login, 3 - add post, 4 - add user, 5 - add comment, 6 - make admin, 7 - exit
        switch (a) {
            case 1: {
                showPosts4Blog();                       //show Posts
                return false;
            }

            case 2: {                                       //login
                System.out.println("Enter user name: ");
                String cUname = readit.readLine();
                System.out.println("Enter user password: ");
                String cUpass = readit.readLine();
                login(cUname, cUpass);
                return false;
            }

            case 3: {                                       //add post
                if (curUserId != -1) {
                    System.out.println("Enter post name: ");
                    String curpName = readit.readLine();
                    System.out.println("Enter post content: ");
                    String curpContent = readit.readLine();
                    addPost2Blog(new Post(curpName, curpContent, blogUser[curUserId]));
                } else System.out.println("Please login first");
                return false;
            }

            case 4: {                                       //add user
                if (curUserId != -1) {
                    if (blogUser[curUserId].getIsAdmin()) {
                        System.out.println("Please enter user name");
                        String s1 = readit.readLine();
                        System.out.println("Please enter user password");
                        String s2 = readit.readLine();
                        addUser(new Users(s1, s2));
                        System.out.println("User " + s1 + " created.");
                    } else System.out.println("ERROR: You don't have admin permissions");
                } else System.out.println("ERROR: Please login first with account having admin permissions");
                return false;
            }

            case 5: {                                       //add comment

                return false;
            }

            case 6: {                                       //make admin
                if (curUserId != -1) {
                    if (blogUser[curUserId].getIsAdmin()) {
                        System.out.println("Please enter user name");
                        String sn = readit.readLine();
                        for (int i = 0; i < 10; i++) {
                            if (blogUser[i].getUserName().equals(sn)) blogUser[i].setIsAdmin(true);
                        }
                    } else System.out.println("ERROR: You don't have admin permissions");
                } else System.out.println("ERROR: Please login first with account having admin permissions");
                return false;
            }

            case 7: {                                       //exit
                return true;
            }

            default: {
                System.out.println("Please enter valid action id. You entered:  \"" + a + "\"  which isn't associated with any action yet!");
                return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //System.out.println("Please login :)");
        WebBlog controller = new WebBlog();
        System.out.println(webBlogName);
        Users admin = new Users ("admin", "admin");
        admin.setIsAdmin(true);
        controller.addUser(admin);

        boolean toExit = false;
        while (!toExit) {
            System.out.println("");
            System.out.println("Please select action: " + legend);
            try {
                toExit = controller.action(Integer.parseInt(readit.readLine()));
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter the number associated with required action.");
            }
        }



    }
}
