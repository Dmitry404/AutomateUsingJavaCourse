package Blog;

/**
 * Created by asinuk on 16/02/2015.
 */
public abstract class MainClass {

    public static void main(String[] args) {

        System.out.println("Hello!");
        User user1 = new User ("Alexey", "Sinyuk");
        Post post1 = new Post ("Post1", user1, "coolstory psto");
        post1.addComment(user1, "Perviy ololo!");
        post1.addComment(user1, "Vtoroy!");
        post1.Print();

        post1.getComment(2).PrintComment();
        post1.getComment(1).Delete();
        post1.Print();

    }

}
