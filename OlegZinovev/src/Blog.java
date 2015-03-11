import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blog {

    static List<User> users = new ArrayList<User>();
    static List<Post> posts = new ArrayList<Post>();

    //////////UserControl//////////
    public static boolean existUser(String login) {
        if (users.size() == 0) {return false;}
        else {
            for (int i = 0; i < users.size(); i++){
                if (login.equals(users.get(i))){return true;}
            }
            return false;
        }
    }
    public static void createUser(){
        Scanner sc = new Scanner(System.in);

        User user = new User();
        String newUserLogin;
        String newUserPassword;

        do {
            System.out.println("Create correct user name, please:");
            newUserLogin = sc.next();
        }
//      нужно ввести проверку на то, пустой ввод или нет.
//      newUserLogin.equals("") или newUserLogin.isEmpty() не работает
        while (!existUser(newUserLogin) && newUserLogin.equals(""));

        System.out.println("Create correct password, please:");
        newUserPassword = sc.next();
        user.createNewUser(newUserLogin, newUserPassword);
        users.add(user);
    }
    public static boolean checkUser(String login, String pass){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUser_login().equals(login)){
                if (users.get(i).getPassword().equals(pass)){
                    return true;
                }
            }
        }
        return false;
    }
    public static User userLogin(){
        Scanner sc = new Scanner(System.in);
        String user_login;
        String password;
        User loggedUser = null;
        do {
            System.out.println("Enter your login, please:");
            user_login = sc.next();
            System.out.println("Enter your password, please");
            password = sc.next();
            if (!checkUser(user_login, password)){
                System.out.println("There is no user with such name and password, try again, please!");
            }
        }
        while (!checkUser(user_login, password));
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUser_login().equals(user_login)){
                loggedUser = users.get(i);
            }
        }
        return loggedUser;
    }

    //////////PostControl//////////
    public static Post createPost(){
        Scanner sc = new Scanner(System.in);

        Post post = new Post();
        String title;
        String body;

        System.out.println("Enter post title:");
        title = sc.next();
        System.out.println("Enter post message:");
        body = sc.next();
        post.createNewPost(title, body);
        return post;
    }

    //////////CommentControl//////////
    public static Comment createComment(){
        Scanner sc = new Scanner(System.in);

        Comment comment = new Comment();
        String body;

        System.out.println("Enter new comment:");
        body = sc.next();
        comment.createNewComment(body);
        return comment;
    }

    public static void main(String[] args){

        createUser();
        User loggedUser = userLogin();
        Post newPost = createPost();
        newPost.setPost_author(loggedUser.getUser_login());
        Comment comment = createComment();
        newPost.getCommentList().add(comment);
        posts.add(newPost);
        //почему вывод в квадратных скобках?
        System.out.println(posts);
    }
}
