import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Comment {
    
    private String comment_body;
    private User comment_author;
    private Post parent_post;
    private int comment_id = 0;

    Scanner sc = new Scanner(System.in);

    public static Map comments = new HashMap();
    
    public void addCommentBody(String comment_body) {
        System.out.println("Print your comment:");
        comment_body = sc.next();
        this.comment_body = comment_body;
    }
    
    public void addNewComment(){
        this.addCommentBody(comment_body);
        comment_id++;
        System.out.println("Your comment was created.");
        comments.put(comment_id, comment_body);
    }

    public User getComment_author() {
        return comment_author;
    }

    public void setComment_author(User comment_author) {
        this.comment_author = comment_author;
    }

    public Post getParent_post() {
        return parent_post;
    }

    public void setParent_post(Post parent_post) {
        this.parent_post = parent_post;
    }
}
