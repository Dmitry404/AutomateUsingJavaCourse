package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;
import java.util.Date;

public abstract class AbstractPage implements Page {
    private int id;
    private int userId;
    private String content;
    private Date creationDate;
    private Date updateDate;
    protected String type = null;
    protected String pageContent = null;

    public AbstractPage(int id, String content, int userId) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        creationDate = new Date();
        updateDate = creationDate;
        setPageType();
    }

    @Override
    public int getPageId() {
        return id;
    }

    @Override
    public Date getPageCreationDate() {
        return creationDate;
    }

    @Override
    public Date getPageLastUpdateDate() {
        return updateDate;
    }

    public String getPageContent() {
        return content;
    }

    @Override
    public void setPageLastUpdateDate(Date lastUpdateDate) {
        updateDate = lastUpdateDate;
    }

    @Override
    public String getPageType() {
        return type;
    }

    protected abstract void  setPageType();
    protected void setPageContant(String pageContant) {
        this.pageContent = pageContant;
    }

    @Override
    public abstract void displayPage(PrintStream out);
}
