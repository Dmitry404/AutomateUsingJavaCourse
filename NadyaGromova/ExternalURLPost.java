/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webblog_new;

/**
 *
 * @author ngromova
 */
import java.util.Scanner;
public class ExternalURLPost extends PostTemplate {
    
    private String post_title;
    private String post_body;
    Scanner st1=new Scanner(System.in);
    
    private void AddPostBody(String body)
    {
        System.out.println("Your post..");
        body=st1.next();
        CheckURL(body);
    }
    
        private String GetPostBody()
    {
        return post_body;
    }
    
    private void CheckURL(String body)
    {
        if(body.contains("http://")==false)//check contains method in main 
        {
            System.out.println("You input incorrect link format.");
        }
        else
        {
            this.post_body=body;
        }
    }
                
    public void AddNewPost()
    {
        AddTitle(post_title);
        AddPostBody(post_body);
        if (post_body==null)
        {
            System.out.println("Post creation was failed.\n");
        }
         else
        {
            System.out.println("\n"+"New post was created\n"+GetPostTitle()+"\n"+GetPostBody()+"\n"+"///////////////\n");
        }
    }
}
