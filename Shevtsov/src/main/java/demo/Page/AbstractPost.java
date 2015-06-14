package demo.Page;

import java.io.PrintStream;
import java.util.Date;

public abstract class AbstractPost implements Post {
    private int id;
    private int userId;
    private String title;
    private Date creationDate;
    private Date updateDate;
    protected String type = null;
    protected String postContent = null;

    public AbstractPost() {
    }

    public AbstractPost(int id, String title, int userId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        creationDate = new Date();
        updateDate = creationDate;
        setPostType();
    }

    @Override
    public int getPostId() {
        return id;
    }

    @Override
    public Date getPostCreationDate() {
        return creationDate;
    }

    @Override
    public Date getPostLastUpdateDate() {
        return updateDate;
    }

    public String getPostTitle() {
        return title;
    }

    @Override
    public void setPostLastUpdateDate(Date lastUpdateDate) {
        updateDate = lastUpdateDate;
    }

    @Override
    public String getPostType() {
        return type;
    }

    protected abstract void setPostType();
    protected void setPostContant(String postContant) {
        this.postContent = postContant;
    }

    @Override
    public abstract void displayPost(PrintStream out);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostContent() {
        return postContent;
    }
}
