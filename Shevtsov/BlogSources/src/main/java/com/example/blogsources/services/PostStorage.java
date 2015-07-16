package com.example.blogsources.services;

import com.example.blogsources.Post.Post;

import java.util.List;

public interface PostStorage {
    void addNewPost(String type, String content, int userId);
    void removePost(int id);
//    void displayPost(int id, PrintStream out);
    List<Post> displayAllPosts();
    void addNewPost(Post post);
}
