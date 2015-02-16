package AutomateUsingJava.lesson1;


import java.util.Date;

public class Post {

    private String postName;
    private String postContent;
    private Users postAuthor;
    private long postDate;
    Comments [] postComments;

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


}
