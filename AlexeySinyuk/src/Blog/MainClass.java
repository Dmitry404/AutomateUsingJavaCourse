package Blog;

/**
 * Created by asinuk on 16/02/2015.
 */
public abstract class MainClass {

    public static void main(String[] args) {

        User user1 = new User ("Ivan", "Ivanov");
        User user2 = new User ("Petro", "Petrov");
        Post post1 = new Post ("Post1", user1, "coolstory psto");
        post1.addComment(user2, "Perviy ololo!");
        post1.addComment(user1, "Vtoroy!");
        post1.Print();

        post1.getComment(2).PrintComment();
        post1.getComment(1).Delete();
        post1.Print();

    }

}
