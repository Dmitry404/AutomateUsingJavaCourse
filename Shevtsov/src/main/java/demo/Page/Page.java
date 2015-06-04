package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;
import java.util.Date;

public interface Page {
    int getPageId();
    String getPageType();
    void displayPage(PrintStream out);
    Date getPageCreationDate();
    Date getPageLastUpdateDate();
    void setPageLastUpdateDate(Date lastUpdateDate);
}
