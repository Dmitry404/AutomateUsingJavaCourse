package AutomateUsingJava.lesson1;


import java.util.Date;

public class Comments {
    private String commentAuthor;
    private String commentContent;
    private Date commentDate;

public Comments (String commentAuthor, String commentContent){
    this.commentAuthor = commentAuthor;
    this.commentContent = commentContent;
    this.commentDate = new Date();
}

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }
}
