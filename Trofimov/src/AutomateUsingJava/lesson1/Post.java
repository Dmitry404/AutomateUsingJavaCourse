package AutomateUsingJava.lesson1;


import java.util.Date;
//import java.System;

public class Post {

    private String postName;
    private String postContent;
    private Users postAuthor;
    private long postDate;
    Comments [] postComments = new Comments [10];
    int commentId = 0;

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

    public String  getPostAuthor() {
        return postAuthor.getUserName();
    }

    public long getPostDate() {
        return postDate;
    }

    public void addComment2Post (Comments k) {

        if (commentId <10) {
        postComments[commentId] = k;
        commentId++;}
            else System.out.println("huy vam!");
    }

    public void showComments2Post () {
        //for (each Comments a : postComments
        for (int i=0; i< commentId; i++) {
            System.out.println(postComments[i].getCommentAuthor() + " commented at: " + postComments[i].getCommentDate());
            System.out.println(postComments[i].getCommentContent());
        }
    }
}
