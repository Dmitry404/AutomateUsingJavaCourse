package com.example.blogsources.Post;

import java.io.PrintStream;

public class ImagePost extends AbstractPost {

    public ImagePost(int id, String content, int userId) {
        super(id,content,userId);
    }

    @Override
    protected void setPostType() {
        type = "image";
    }

    @Override
    public void displayPost(PrintStream out) {out.println("There is I have to show a image - " + super.getPostTitle());
    }
}
