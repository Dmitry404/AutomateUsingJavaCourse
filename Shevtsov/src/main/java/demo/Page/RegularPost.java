package demo.Page;

import java.io.PrintStream;

public class RegularPost extends AbstractPost {

    public RegularPost(int id, String content, int userId) {
        super(id,content,userId);
    }

    public RegularPost() {
        super();
        setPostType();
    }

    @Override
    protected void setPostType() {
        type = "regular";
    }

    @Override
    public void displayPost(PrintStream out) {
        System.out.println("The Regular page was created" + super.getPostCreationDate() + "Content:S");
        out.println(super.getPostTitle() + "\n" );
    }
    public void setPostContent (String content){
        postContent = content;
    }
}
