package demo.Users;

public class BasicUser implements User {
    private int userId;
    private String userName;
    private String password;
    private int userPrivilegeLevel;
    // 0 - root privilege,
    // 1 - user that add comments
    // 2+ - like a guest
    // 100 - a guest

    public BasicUser() {
        this.userId = -1;
        this.userName = "Default User Name";
        this.userPrivilegeLevel = 2;
    }

    BasicUser(int id, String userName,int userPrivilegeLevel){
        this.userId = id;
        this.userName = userName;
        this.userPrivilegeLevel = userPrivilegeLevel;
    }
    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPrivilegeLevel(int userPrivilegeLevel) {
        this.userPrivilegeLevel = userPrivilegeLevel;
    }

    @Override
    public int getUserPrivilegeLevel() {
        return userPrivilegeLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
