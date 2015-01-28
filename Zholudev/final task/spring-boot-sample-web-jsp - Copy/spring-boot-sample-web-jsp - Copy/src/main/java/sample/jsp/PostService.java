package sample.jsp;


import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    void addPost(Post post);

}
