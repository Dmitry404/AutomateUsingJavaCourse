
package webblog_new;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Users {
    
   public String login_user;
   public String password;
  
   //public ArrayList AL=new ArrayList();
   public Map mp=new HashMap();
   
   Scanner u= new Scanner(System.in);
 
      
   private void AddUserLogin (String login)
   {
       System.out.println("Login name...");
       login=u.next();
       this.login_user=login;
       }
   
   private String GetUserLogin ()
   {
       return login_user;
   }
   
   private void CreateUser()
   {
       AddUserLogin(login_user);
       System.out.println("User "+this.GetUserLogin().toUpperCase()+" has been successfully created.\nYou may  start submit your posts.\n");
       for (int i=mp.size();i>0;i--)
       {
           mp.put(i+1, login_user);
           break;
       }
   }
   
   
   private void CheckUser(String login_user)
           
      {
         if (mp.containsValue(login_user)==true)
       {
           System.out.println("Input your password...");
           password=u.next();           
       }
       else 
       {
           CreateUser();
           //AL.add(login_user);
       }
   }
   
   
   
   
   public void UserLogin()
   {
       CheckUser(login_user);
   }
  
}

