import java.util.ArrayList;
import java.util.List;

public class Post {
    private String post_title;
    private String post_body;
    private String post_author;

    private List<Comment> commentList;

    public Post(){
        post_title = "";
        post_body = "";
        post_author = "";
        commentList = new ArrayList<Comment>();
    }

    public void createNewPost(String title, String body){
        setPost_title(title);
        setPost_body(body);
    }

    public String toString(){
        return "Title:\n" + this.getPost_title() + "\nAuthor:\n" +
                this.getPost_author() + "\nMessage:\n" + this.getPost_body() +
                "\nComments:\n" + this.getCommentList().toString();
    }

    public String getPost_title() {
        return post_title;
    }
    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }
    public String getPost_body() {
        return post_body;
    }
    public void setPost_body(String post_body) {
        this.post_body = post_body;
    }
    public String getPost_author() {
        return post_author;
    }
    public void setPost_author(String post_author) {
        this.post_author = post_author;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }
}
