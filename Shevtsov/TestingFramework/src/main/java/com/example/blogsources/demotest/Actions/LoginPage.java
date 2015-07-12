package com.example.blogsources.demotest.Actions;

import com.example.blogsources.demotest.Driver;
import com.example.blogsources.demotest.utils.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.example.blogsources.URLMap.URLMap.*;

public class LoginPage {
    private static String SUBMIT_INPUT_XPATH = "//input[@test-id='submit-login']";
    private static String USERNAME_INPUT_XPATH = "//input[@test-id='input-username']";
    public static String PASSWORD_INPUT_XPATH = "//input[@test-id='input-password']";
    private static String USERNAME_ID = "username";
    public static void go(){
        Driver.driver.navigate().to(FULL_LOGIN);
    }

    public static boolean at(){
        boolean result = false;
        result = (Driver.driver.getCurrentUrl().toString().equals(FULL_LOGIN) &&
                Elements.isFoundAndDisplayed(By.xpath(SUBMIT_INPUT_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(USERNAME_INPUT_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(PASSWORD_INPUT_XPATH)))
                ? true :false;
        return result;
    }

    public static void login (String username, String password){
        WebElement usernameElement = Elements.getElement(By.xpath(USERNAME_INPUT_XPATH));
        if (usernameElement != null) {usernameElement.sendKeys(username);}
        WebElement passwordElement = Elements.getElement(By.xpath(PASSWORD_INPUT_XPATH));
        if (passwordElement != null) {
            passwordElement.sendKeys(password);
            passwordElement.submit();
        }
    }

    public static boolean isLoggedIn (){
        WebElement element = null;
            return (Elements.isFoundAndDisplayed(By.id(USERNAME_ID))) ? true : false;
    }

    public static boolean isLoggedInAs (String username){
        return (Elements.isFoundAndDisplayed(By.id(USERNAME_ID)) && Elements.getElement(By.id(USERNAME_ID)).getText().equals(username)) ? true : false;
    }

}
