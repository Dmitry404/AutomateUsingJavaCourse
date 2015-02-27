
package webblog_new;

import java.util.Scanner;

public  class RegularPost extends PostTemplate{
    
    private String post_title;
    private String post_body;
    Scanner st1=new Scanner(System.in);
    
    private void AddPostBody(String body)
    {
        System.out.println("Your post..");
        body=st1.next();
        this.post_body=body;
    }
    
    private String GetPostBody()
    {
        return post_body;
    }
    
    public void AddNewPost()
    {
        AddTitle(post_title);
        AddPostBody(post_body);
        System.out.println("\n"+"New post was created\n"+GetPostTitle()+"\n"+GetPostBody()+"\n"+"///////////////\n");
    }
}
