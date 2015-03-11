public class User {

    private String user_login;
    private String password;

    public User (){
        user_login = "";
        password = "";
    }

    public void createNewUser (String login, String pass){
        setUser_login(login);
        setPassword(pass);
    }

    public String getUser_login() {
        return user_login;
    }
    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
