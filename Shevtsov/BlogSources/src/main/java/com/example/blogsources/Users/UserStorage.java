package com.example.blogsources.Users;

import java.io.PrintStream;

public interface UserStorage {
    public void addNewUser (User user);
    public void removeUser (int id);
    public void removeUser (String name);
    public void showAllUser (PrintStream output);
    public int getUserId(String name);
    public String getUserName(int id);
    public int getUserPrivilegeLevel(String name);
    public boolean userIdExists(int id);
    public boolean userNameExists(String name);
    public boolean validateUser(User user);
}
