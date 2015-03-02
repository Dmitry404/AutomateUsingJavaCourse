package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog;

import com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page.PageStorage;
import com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page.PagesInRam;
import com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Users.UserStorage;
import com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Users.UsersInRam;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WebBlog {
    private InputStream input;
    private PrintStream output;
    private UserStorage users = new UsersInRam();
    private PageStorage pages = new PagesInRam();
    private String activeUser= null;

    public WebBlog() {
        input = System.in;
        output = System.out;
    }

    public WebBlog(InputStream in, PrintStream out) {
        input = in;
        output = out;
    }

    public void addUser(){
        output.print("Please input a new user name:");
        Scanner in = new Scanner(input);
        String name = in.next();
        output.print("\nPlease input a new user user's privilege level\n" +
                "    // 0 - root privilege,\n" +
                "    // 1 - user that add comments\n" +
                "    // 3 - a guest\n" +
                "User's privilege level:");
        int userPrivilegeLevel = -1;
        try {
            userPrivilegeLevel = in.nextInt();
        }catch (InputMismatchException e){
            output.println("The User's privilege level incorrect: "+userPrivilegeLevel);
            return;
        }
        addUser(name,userPrivilegeLevel);
    }

    public void addUser(String name, int userPrivilegeLevel){
        // I set it as public for testing.
        users.addNewUser(name, userPrivilegeLevel);
    }

    public void showAllUsers (){users.showAllUser(output);}

    public void setActiveUser (int id){
        if (users.userIdExists(id)) {
            activeUser = users.getUserName(id);
//            System.out.println("Active user: " + activeUser + "with ID:" + id);
        } else {
            output.println("This user id isn't existed :" + id +"\n" +
                    "Please specify a correct user id\n");

        }
    }

    public void AddNewRegularPage(String content){
        if (activeUser != null) {
            if (users.getUserPrivilegeLevel(activeUser) == 0) {
                pages.addNewPage("regular", content, users.getUserId(activeUser));
            }else{
                output.println("Only user with admin Privilege Level can add pages\n" +
                        "Your user " + activeUser + "has a PrivilegeLevel" + users.getUserPrivilegeLevel(activeUser));
            }
        }else {
            output.println("You didn't set a active user\nOnly user with admin Privilege Level can add pages");
        }
    }

    public void AddNewUrlPage(String content){
        if (activeUser != null) {
            if (users.getUserPrivilegeLevel(activeUser) == 0) {

        pages.addNewPage("url",content, users.getUserId(activeUser));
            }else{
                output.println("Only user with admin Privilege Level can add pages\n" +
                        "Your user " + activeUser + " has a PrivilegeLevel" + users.getUserPrivilegeLevel(activeUser));
            }
        }else {
            output.println("You didn't set a active user\nOnly user with admin Privilege Level can add pages");
        }

    }

    public void AddNewImagePage(String content){
            if (activeUser != null) {
                if (users.getUserPrivilegeLevel(activeUser) == 0) {

        pages.addNewPage("image",content, users.getUserId(activeUser));
                }else{
                    output.println("Only user with admin Privilege Level can add pages\n" +
                            "Your user " + activeUser + "has a PrivilegeLevel" + users.getUserPrivilegeLevel(activeUser));
                }
            }else {
                output.println("You didn't set a active user\nOnly user with admin Privilege Level can add pages");
            }

    }

    public void displayAllPages() {
        pages.displayAllPages(output);
    }

    public void displayPage(int num) {
        pages.displayPage(num, output);
    }


}
