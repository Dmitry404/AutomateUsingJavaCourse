package com.example.blogsources.demotest.Actions;

import com.example.blogsources.demotest.Driver;
import com.example.blogsources.demotest.utils.Elements;
import org.openqa.selenium.By;

import static com.example.blogsources.URLMap.URLMap.FULL_LOGOUT;

public class LogoutPage {
    private static String TOP_LOGIN_URL_ID = "top-login";
    public static void go(){
        Driver.driver.navigate().to(FULL_LOGOUT);
    }

    public static boolean at(){
        return (Elements.isFoundAndDisplayed(By.id(TOP_LOGIN_URL_ID)) && Driver.driver.getCurrentUrl().toString().equals(FULL_LOGOUT)) ? true :false;
    }

    public static void logout (){
        go();
    }

    public static boolean isLoggedOut (){
            return (Elements.isFoundAndDisplayed(By.id(TOP_LOGIN_URL_ID))) ? true : false;
    }
}
