package demo.Users;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface User  {
    int getUserId();
    void setUserId(int userId);
    String getUserName();
    void setUserName(String userName);
    String getPassword();
    void setPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    String getEmail();
    void setEmail(String email);
    // 0 - root privilege,
    // 1 - user that add comments
    // 3 - a guest
    int getUserPrivilegeLevel();
    void setUserPrivilegeLevel(int userPrivilegeLevel);
}
