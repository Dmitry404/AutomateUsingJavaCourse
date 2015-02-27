
package webblog_new;

import java.util.Scanner;

public abstract class PostTemplate {
    
    private String post_title;
        
    Scanner st=new Scanner(System.in);
    
    public void AddTitle(String title) 
    {
       System.out.println("Input title for your post");
       title=st.next();
       this.post_title=title;
       
    }
    public String GetPostTitle()
    {
        return post_title;
    }  
    
    public abstract void AddNewPost();
            
   
    
}
