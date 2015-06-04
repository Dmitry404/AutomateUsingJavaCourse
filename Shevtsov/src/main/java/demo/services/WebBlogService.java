package demo.services;

import org.springframework.stereotype.Service;
import demo.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebBlogService {
    private Map<String, Post> posts = new HashMap<>();

    public void addPost(Post post) {
        posts.put(post.getTitle(), post);
    }

    public List<Post> getAllPosts() {
        return new ArrayList(posts.values());
    }

    public Post getPostByTitle(String postTitle) {
        return posts.get(postTitle);
    }
}
