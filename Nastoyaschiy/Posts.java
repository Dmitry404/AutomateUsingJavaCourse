import java.util.ArrayList;


public class Posts {

    private ArrayList<Post> blogdb = new ArrayList<Post>(0);
    private int lastID;

    public void addpost(Post post) {
        lastID++;
        post.setId(lastID);
        blogdb.add(post);
    }

    public Post get(int id) {
        Post post;
        post = null;
        for (Post p : blogdb) {
            if (p.getId() == id) {
                post = p;
                break;
            }
        }
        return post;
    }

    public void search(String s, String field) {
        boolean found = false;
        boolean eq = false;
        for (Post post : blogdb) {
            if (field.equals("title")) eq = post.getHead().contains(s);
            if (field.equals("text")) eq = post.getBody().contains(s);
            if (field.equals("tag")) eq = post.getTag().contains(s);
            if (eq) {
                output.outpost(post);
                found = true;
            }
        }
        if (!found) {
            System.out.println();
            System.out.println("Posts with " + field + " \"" + s + "\" not found");
            System.out.println();
        }
    }

    public void delete(int id) {
        for (int i = 0; i < blogdb.size(); i++) {
            if (blogdb.get(i).getId() == id) {
                blogdb.remove(i);
                System.out.println();
                System.out.println("Post ID " + id + " was delete");
                break;
            }
        }
        blogdb.trimToSize();
    }

}
