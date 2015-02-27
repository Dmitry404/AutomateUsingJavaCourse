package com.javacourses.homework1;

public class WebBlogComment extends WebBlog {

    private int commentId;
    private String body;
    public WebBlogComment() {}

    public int newComment(int parentPostId, int parentCommentId, String body) {
        if (parentPostId != 0 && parentCommentId == 0) {
            commentId = 1337;
            System.out.println(classname() + "New comment form (reply to post) was opened. Comment content - \"" + body + "\"");
        } else if(parentPostId == 0 && parentCommentId != 0) {
            commentId = 1338;
            System.out.println(classname() + "New comment form (reply to comment) was opened");
        }
        return commentId;
    }

    public void editComment(int commentId, String body) {
        if (commentId != 0) {
            System.out.println(classname() + "Edit comment form was opened. Comment content was changed to \"" + body + "\"");
        }
    }

    public void deleteComment(int commentId) {
        if (commentId != 0) {
            System.out.println(classname() + "Comment with id=" + commentId + " was deleted successfully");
        }
    }

    public void submitCommentForm(int commentId) {
        if (commentId != 0) {
            System.out.println(classname() + "Comment " + commentId + " submitted");
        }
    }

}
