package demo.Page;

import java.io.PrintStream;
import java.util.Date;

public interface Post {
    int getPostId();
    String getPostTitle();
    String getPostContent();
    String getPostType();
    void displayPost(PrintStream out);
    Date getPostCreationDate();
    Date getPostLastUpdateDate();
    void setPostLastUpdateDate(Date lastUpdateDate);
}
