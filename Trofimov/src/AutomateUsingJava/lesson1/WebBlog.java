package AutomateUsingJava.lesson1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WebBlog {

    protected String webBlogName = "Team work: Lesha, Artem, Viktor";
    protected static String legend = "1 - show Posts, 2 - login, 3 - add post, 4 - add user, 5 - add comment, 6 - make admin, 7 - exit";
    Post [] blogPosts = new Post [10];
    int postId = 0;
    Users [] blogUser = new Users [10];
    int userId =0;
    int curUserId=-1;
    BufferedReader readit = new BufferedReader(new InputStreamReader(System.in));

    public void addPost2Blog (Post p) {

        if (postId <10) {
            blogPosts[postId] = p;
            postId++;}
        else System.out.println("huy vam!");
    }

    public void showPosts4Blog () {
        //for (each Comments a : postComments
        for (int i=0; i< postId; i++) {
            System.out.println(blogPosts[i].getPostName() + " created by: " + blogPosts[i].getPostAuthor() + " at " + blogPosts[i].getPostDate());
            System.out.println(blogPosts[i].getPostContent());
            blogPosts[i].showComments2Post();
        }
    }

    public void addUser(Users u) {
        if (userId < 10) {
            blogUser[userId] = u;
            userId++;
            }
        else System.out.println("huy vam!");
    }


    public void login (String l, String p){
        for (int i=0; i<10; i++) {
            if (l==blogUser[i].getUserName()){
                if (p==blogUser[i].getUserPassword()) curUserId=i;
            }
        }
    }

    public void action (int a) throws IOException {
        // 1 - show Posts, 2 - login, 3 - add post, 4 - add user, 5 - add comment, 6 - make admin, 7 - exit
        if (a==1) showPosts4Blog();
        if (a==2) {
            System.out.println("Enter user name: ");
            String cUname = readit.readLine();
            System.out.println("Enter user password: ");
            String cUpass = readit.readLine();
            login(cUname,cUpass);
        }
        if (a==3) {
            if (curUserId >-1){
                System.out.println("Enter post name: ");
                String curpName = readit.readLine();
                System.out.println("Enter post content: ");
                String curpContent = readit.readLine();

                new Post(curpName, curpContent, blogUser[curUserId]);
            }
            else System.out.println("Please login first");
        }
    }

   public static void main(String[] args) {
       //System.out.println("Please login :)");
     WebBlog controller = new WebBlog();


       boolean toExit = false;
       while (toExit) {
           System.out.println("Please select action: " + legend);
           action(Integer.parseInt(readit.readLine()));
       }



       }
}
