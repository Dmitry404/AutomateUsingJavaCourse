package Blog;

import javafx.geometry.Pos;


public class User {

    private String name;
    private String surname;
    private int posts = 0;
    private int comments = 0;

    public User (String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getPosts (){
        return posts;
    }

    int incPosts (){
        posts++;
        return posts;
    }

    int decPosts (){
        posts--;
        return posts;
    }

    public int getCommentsNum() {
        return comments;
    }
}
