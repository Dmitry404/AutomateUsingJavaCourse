package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;

public interface PageStorage {
    void addNewPage(String type, String content, int userId);
    void removePage(int id);
    void displayPage (int id, PrintStream out);
    void displayAllPages (PrintStream out);
}
