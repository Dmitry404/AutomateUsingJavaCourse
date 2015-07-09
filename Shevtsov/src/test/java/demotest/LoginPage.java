package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static demo.Page.URLMap.*;
import static demotest.Driver.driver;
import static demotest.utils.Elements.getElement;
import static demotest.utils.Elements.isFoundAndDisplayed;

public class LoginPage {
    private static String SUBMIT_INPUT_XPATH = "//input[@test-id='submit-login']";
    private static String USERNAME_INPUT_XPATH = "//input[@test-id='input-username']";
    public static String PASSWORD_INPUT_XPATH = "//input[@test-id='input-password']";
    private static String USERNAME_ID = "username";
    public static void go(){
        driver.navigate().to(FULL_LOGIN);
    }

    public static boolean at(){
        boolean result = false;
        result = (driver.getCurrentUrl().toString().equals(FULL_LOGIN) &&
                isFoundAndDisplayed(By.xpath(SUBMIT_INPUT_XPATH)) &&
                isFoundAndDisplayed(By.xpath(USERNAME_INPUT_XPATH)) &&
                isFoundAndDisplayed(By.xpath(PASSWORD_INPUT_XPATH)))
                ? true :false;
        return result;
    }

    public static void login (String username, String password){
        WebElement usernameElement = getElement(By.xpath(USERNAME_INPUT_XPATH));
        if (usernameElement != null) {usernameElement.sendKeys(username);}
        WebElement passwordElement = getElement(By.xpath(PASSWORD_INPUT_XPATH));
        if (passwordElement != null) {
            passwordElement.sendKeys(password);
            passwordElement.submit();
        }
    }

    public static boolean isLoggedIn (){
        WebElement element = null;
            return (isFoundAndDisplayed(By.id(USERNAME_ID))) ? true : false;
    }

    public static boolean isLoggedInAs (String username){
        return (isFoundAndDisplayed(By.id(USERNAME_ID)) && getElement(By.id(USERNAME_ID)).getText().equals(username)) ? true : false;
    }

}
