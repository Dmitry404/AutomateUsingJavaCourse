import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Post {
    
    private String post_title;
    private String post_body;
    private User post_author;

    public static Map posts = new HashMap();

    Scanner sc = new Scanner(System.in);

    public void addPostTitle(String title) {
        title = sc.next();
        post_title = title;
    }
    
    public void addPostBody(String body) {
        System.out.println("Print your message:");
        body = sc.next();
        post_body = body;
    }
    
    public void AddNewPost(){
        this.addPostTitle(post_title);
        this.addPostBody(post_body);
        System.out.println("Your post was created.");
        posts.put(post_title, post_body);
    }

    public String getPostTitle() {
        return post_title;
    }
    
    public String getPostBody() {
        return post_body;
    }

    public User getPost_author() {
        return post_author;
    }

    public void setPost_author(User post_author) {
        this.post_author = post_author;
    }
}
