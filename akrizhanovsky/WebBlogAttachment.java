package com.javacourses.homework1;

public class WebBlogAttachment extends WebBlogPost {

    //private String[] attachmentType = { "image", "audio", "video", "document", "url" };

    public WebBlogAttachment() {}

    public int add(int postId, int commentId, String attachmentType, String body_base64) {
        if (postId != 0 && commentId == 0) {
            System.out.println(classname() + attachmentType + " was attached to post with id=" + postId);
            attachId = 1337;
        } else if (postId == 0 && commentId != 0) {
            System.out.println(classname() + attachmentType + " was attached to comment with id=" + commentId);
        }
        attachId = 0;
        return attachId;
    }

    public void delete(int postId, int attachId) {
        if (postId != 0) System.out.println(classname() + "Attachment " + attachId + " was deleted");
    }

}
