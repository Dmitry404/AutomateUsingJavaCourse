/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webblog_new;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ngromova
 */
public class PostHandling {
    
    
    public void Selector()
        {    
        System.out.println("Select post type.\n 1.Regular post.\n 2.External URL post.\n");
        Scanner sc=new Scanner(System.in);
        int choise = 0;
        
       try
         {
            if (sc.hasNext())
            { 
                choise=sc.nextInt();
            }
         }
         catch (InputMismatchException ex)
         {
            System.out.println("Input error, try again.");
            
          }
        
        
           switch (choise)
       {
           case 1:
               
         ArrayList <RegularPost>  rposts=new ArrayList <RegularPost>(); 
         
         RegularPost rpost= new RegularPost();
         rpost.AddNewPost(); 
         rposts.add(rpost);
         
          break;
               
          case 2:
               
         ArrayList <ExternalURLPost>  euposts=new ArrayList <ExternalURLPost>(); 
         ExternalURLPost eupost= new ExternalURLPost();
         eupost.AddNewPost(); 
         euposts.add(eupost);
         
       break;
               
       default:
                   
        System.out.println("You did not select a post type...");
        break;
       }
          System.out.println("Would you like to submit an additional  post?\n Y/N"); 
           
     }
     
   public boolean Switcher ()
   {
       String YN;
       Scanner sc1=new Scanner(System.in);
       YN=sc1.next();
       boolean stop = false;
       

         switch (YN)
      {
       case "Y":{
           Selector();
           return false;

       }   
       case "N":{
           stop = true;
           return true;
   
       }
       default:
         System.out.println("You input incorrect value...");   
          
       }
      
      return false;
      
   }
    
}
