package demo.services;

import demo.Page.Exceptions.IllegalPageTypeException;
import demo.Page.Exceptions.NotExistsPageException;
import demo.Page.ImagePost;
import demo.Page.Post;
import demo.Page.RegularPost;
import demo.Page.URLPost;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsInRam implements PostStorage {
    private List<Post> posts = new ArrayList<>();

    public void addNewPost(String type, String content, int userId) {
        posts.add(new RegularPost(posts.size(), content, userId));

//        switch (type){
//            case "regular": //System.out.println("Add a new regular page #" + posts.size() + " and userId = " + userId+ "\n" + "Content:" + content+"\n");
//                            posts.add(new RegularPost(posts.size(), content, userId));
//                            break;
//            case "url": posts.add( new URLPost(posts.size(), content, userId));
//                            break;
//            case "image": posts.add( new ImagePost(posts.size(), content, userId));
//                            break;
//            default:
//                throw new IllegalPageTypeException("Invalid type of the page: " + type + "Expected values regular/url/image");
//        }
    }


    public void removePost(int id) {
        if (id  < 0 || id > posts.size()) {
            throw new NotExistsPageException("Invalid id of the page: " + id + "\nmin value: 0;\n" + "Max Value: " + posts.size() );
        } else {
            posts.remove(id);
        }
    }

    public void displayPost(int id, PrintStream out) {
//        out.println("try to get page #"+id + " " + posts.get(id).getPostType() + " "  + posts.get(id).getPostCreationDate() + "\n");
        if (id  < 0 || id > posts.size()) {
            throw new NotExistsPageException("Invalid id of the page: " + id + "\nmin value: 0;\n" + "Max Value: " + posts.size() );
        } else {
            posts.get(id).displayPost(out);
        }
    }

    @Override
    public List<Post> displayAllPosts() {
        return posts;
    }

    public void addNewPost(Post post) {
        posts.add(post);
    }
}
