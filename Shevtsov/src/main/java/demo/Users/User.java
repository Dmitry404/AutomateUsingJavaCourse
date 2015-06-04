package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Users;

public interface User {
    int getUserId();
    String getUserName();
    // 0 - root privilege,
    // 1 - user that add comments
    // 3 - a guest
    int getUserPrivilegeLevel();
}
