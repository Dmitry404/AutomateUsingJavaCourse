import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {

    private String user_login;
    private String password;

    public Map users = new HashMap();
    
    Scanner sc = new Scanner(System.in);
    
    private void newUserLogin(String login){
        System.out.println("Print your new login name:");
        login = sc.next();
        if(users.containsKey(login)){
            this.user_login = login;
        }
        else{
            System.out.println("This login name is already in use!");
        }
    }    
    
    public void createNewUser(String password){
        this.newUserLogin(user_login);
        if(!this.user_login.isEmpty()){
            System.out.println("Print new password:");
            password = sc.next();
            this.password = password;            
        }
        else {
            System.out.println("You must have create login at first!");
        }
        if (!this.user_login.isEmpty() && !this.password.isEmpty()) {
            users.put(user_login, this.password);
        }
    }

    public boolean checkUser(String user_login, String password) {
        if (users.containsKey(user_login) && password.equals(users.get(user_login))){
            return true;
        }
        return false;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getPassword() {
        return password;
    }
}
