package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;

public class URLPage extends AbstractPage{

    public URLPage(int id, String content, int userId) {
        super(id,content,userId);
    }

    @Override
    protected void setPageType() {
        type = "url";
    }

    @Override
    public void displayPage(PrintStream out) {
        out.println("There is I have to get and show data from the extended URL - " + super.getPageContent());
    }
}
