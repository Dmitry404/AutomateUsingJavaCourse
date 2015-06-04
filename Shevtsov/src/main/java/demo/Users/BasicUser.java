package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Users;

public class BasicUser implements User {
    private int id;
    private String name;
    private int privilegeLevel;
    // 0 - root privilege,
    // 1 - user that add comments
    // 2+ - like a guest
    // 100 - a guest
    BasicUser(int id, String name,int privilegeLevel){
        this.id = id;
        this.name = name;
        this.privilegeLevel = privilegeLevel;
    }
    @Override
    public int getUserId() {
        return id;
    }

    @Override
    public String getUserName() {
        return name;
    }

    @Override
    public int getUserPrivilegeLevel() {
        return privilegeLevel;
    }
}
