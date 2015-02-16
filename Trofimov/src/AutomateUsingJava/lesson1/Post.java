package AutomateUsingJava.lesson1;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private String postName;
    private String postContent;
    private Users postAuthor;
    private long postDate;
    List <Comments> postComments = new ArrayList <Comments> ();

   public Post (String postName, String postContent, Users postAuthor) {
       this.postAuthor = postAuthor;
       this.postName = postName;
       this.postContent = postContent;
       this.postDate = new Date().getTime();
   }

    public String getPostName() {
        return postName;
    }

    public String getPostContent() {
        return postContent;
    }

    public Users getPostAuthor() {
        return postAuthor;
    }

    public long getPostDate() {
        return postDate;
    }

    public Comments addComment2Post (String commentAuthor, String commentContent) {

        //postComments.add();
    }
}
