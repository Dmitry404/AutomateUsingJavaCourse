package demo.services;

import demo.Page.Post;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public interface PostStorage {
    void addNewPost(String type, String content, int userId);
    void removePost(int id);
//    void displayPost(int id, PrintStream out);
    List<Post> displayAllPosts();
    void addNewPost(Post post);
}
