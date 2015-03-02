package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;

public class RegularPage extends AbstractPage{

    public RegularPage(int id, String content, int userId) {
        super(id,content,userId);
    }

    @Override
    protected void setPageType() {
        type = "regular";
    }

    @Override
    public void displayPage(PrintStream out) {
//        System.out.println("Regular page, pageContent" + super.getPageContent());
        out.println(super.getPageContent());
    }
}
