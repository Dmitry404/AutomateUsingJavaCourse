package sample.jsp;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    List<Post> posts = new ArrayList<Post>();

    public List<Post> getAllPosts() {
        return posts;
    }

    public void addPost(Post post) {
    posts.add(post);
    }
}
