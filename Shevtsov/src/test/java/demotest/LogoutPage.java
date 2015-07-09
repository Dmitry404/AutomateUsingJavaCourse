package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static demo.Page.URLMap.FULL_LOGIN;
import static demo.Page.URLMap.FULL_LOGOUT;
import static demotest.Driver.driver;
import static demotest.utils.Elements.getElement;
import static demotest.utils.Elements.isFoundAndDisplayed;

public class LogoutPage {
    private static String TOP_LOGIN_URL_ID = "top-login";
    public static void go(){
        driver.navigate().to(FULL_LOGOUT);
    }

    public static boolean at(){
        return (isFoundAndDisplayed(By.id(TOP_LOGIN_URL_ID)) && driver.getCurrentUrl().toString().equals(FULL_LOGOUT)) ? true :false;
    }

    public static void logout (){
        go();
    }

    public static boolean isLoggedOut (){
            return (isFoundAndDisplayed(By.id(TOP_LOGIN_URL_ID))) ? true : false;
    }
}
