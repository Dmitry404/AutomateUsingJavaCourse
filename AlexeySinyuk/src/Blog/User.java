package Blog;

import javafx.geometry.Pos;

/**
 * Created by asinuk on 16/02/2015.
 */
public class User {

    private String Name;
    private String Surname;
    private int Posts = 0;

    public User (String Name, String Surname){
        this.Name = Name;
        this.Surname = Surname;
    }

    public String getName(){
        return Name;
    }

    public String getSurname(){
        return Surname;
    }

    public int getPosts (){
        return Posts;
    }

    int incPosts (){
        Posts++;
        return Posts;
    }

    int decPosts (){
        Posts--;
        return Posts;
    }

}
