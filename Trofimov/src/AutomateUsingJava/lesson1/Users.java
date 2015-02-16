package AutomateUsingJava.lesson1;


public class Users {


    private String userName;
    private String userPassword;
    private boolean isAdmin;

    public Users (String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.isAdmin = false;
    }

    public void setIsAdmin (boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserName (){
        return this.userName;
    }

}
