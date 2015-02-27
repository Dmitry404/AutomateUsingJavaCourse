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
public class WebBlog_new {

     
   
   
      
    public static void main(String[] args)  {
        
       Users u1=new Users();
       u1.UserLogin();
       
       PostHandling ph=new PostHandling();
       ph.Selector();

       boolean stop = false;
       while(!stop){
          stop =  ph.Switcher(); 
       }
        
       
       
       
      ////////////////////////////////////////////////////////////////////////// 
        //u1.CheckUser();//check if user exists in DB. If yes call function login (ask enter passwoord?)else create
        //ul.CreateUser(); was used in previous code
                
        //option to output all submitted by current user posts Y/N; posts could be output by sort
        
       
       
       /*u1.AL.add("user1");
       u1.AL.add("user2");
       
       System.out.println("input user\n");
       Scanner usc=new Scanner(System.in);
       String user=usc.next();
       //u1.AL.add(user);
       
       //System.out.println(u1.AL.contains(user));
       
       if (u1.AL.contains(user)==true)
         {
           System.out.println("Input your password...");
           String password=usc.next();           
       }  
       
       else
       {
           System.out.println("User is not found");
           u1.AL.add(user);
       }
       
       for (int i=0; i< u1.AL.size();i++)
       {
         System.out.println(u1.AL.get(i));
       }*/
       
       
       
    ////////////////////////////////////////////////////////////////   
                
       
    
       
       
       
       
        
       //System.out.println(n+" posts have been submitted by user "+u1.login_user.toUpperCase());
               
       

       
       
    }
}
    

