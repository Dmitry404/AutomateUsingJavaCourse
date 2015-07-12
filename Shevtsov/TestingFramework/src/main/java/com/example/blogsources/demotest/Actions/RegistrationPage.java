package com.example.blogsources.demotest.Actions;

import com.example.blogsources.demotest.Driver;
import com.example.blogsources.demotest.utils.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.example.blogsources.URLMap.URLMap.FULL_REGISTER;

public class RegistrationPage {
    private static String SUBMIT_REGISTRATION_XPATH = "//input[@test-id='submit-register']";
    private static String EMAIL_REGISTRATION_XPATH = "//input[@test-id='register-email']";
    private static String USERNAME_REGISTRATION_XPATH = "//input[@test-id='register-username']";
    public static String PASSWORD_REGISTRATION_XPATH = "//input[@test-id='register-password']";
    public static void go(){
        Driver.driver.navigate().to(FULL_REGISTER);
    }

    public static boolean at(){
        boolean result = false;
        result = (Driver.driver.getCurrentUrl().toString().equals(FULL_REGISTER) &&
                Elements.isFoundAndDisplayed(By.xpath(SUBMIT_REGISTRATION_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(EMAIL_REGISTRATION_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(USERNAME_REGISTRATION_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(PASSWORD_REGISTRATION_XPATH)))
                ? true :false;
        return result;
    }

    public static void register (String email, String username, String password){
        WebElement emailElement = Elements.getElement(By.xpath(EMAIL_REGISTRATION_XPATH));
        if (emailElement != null) {emailElement.sendKeys(email);}
        WebElement usernameElement = Elements.getElement(By.xpath(USERNAME_REGISTRATION_XPATH));
        if (usernameElement != null) {usernameElement.sendKeys(username);}
        WebElement passwordElement = Elements.getElement(By.xpath(PASSWORD_REGISTRATION_XPATH));
        if (passwordElement != null) {
            passwordElement.sendKeys(password);
            passwordElement.submit();
        }
    }

    public static boolean getRegistrationStatus(){
        if ( Elements.isFoundAndDisplayed(By.id("error_message")) == true ){
            return false;
        }
        if ( Elements.isFoundAndDisplayed(By.id("message")) != true ){
            return false;
        }
        WebElement message = Elements.getElement(By.id("message"));
        if (message.getText().contains("was successfully registered")){
            return true;
        }else {
            return false;
        }
    }
}
