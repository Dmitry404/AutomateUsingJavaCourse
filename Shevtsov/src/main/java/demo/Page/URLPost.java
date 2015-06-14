package demo.Page;

import java.io.PrintStream;

public class URLPost extends AbstractPost {

    public URLPost(int id, String content, int userId) {
        super(id,content,userId);
    }

    @Override
    protected void setPostType() {
        type = "url";
    }

    @Override
    public void displayPost(PrintStream out) {
        out.println("There is I have to get and show data from the extended URL - " + super.getPostTitle());
    }
}
