package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;

public class ImagePage extends AbstractPage{

    public ImagePage(int id, String content, int userId) {
        super(id,content,userId);
    }

    @Override
    protected void setPageType() {
        type = "image";
    }

    @Override
    public void displayPage(PrintStream out) {out.println("There is I have to show a image - " + super.getPageContent());
    }
}
