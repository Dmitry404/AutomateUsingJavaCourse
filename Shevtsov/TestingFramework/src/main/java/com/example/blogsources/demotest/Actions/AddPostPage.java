package com.example.blogsources.demotest.Actions;

import com.example.blogsources.demotest.Driver;
import com.example.blogsources.demotest.utils.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.example.blogsources.URLMap.URLMap.FULL_ADDPOST;
import static com.example.blogsources.URLMap.URLMap.FULL_REGISTER;

public class AddPostPage {
    private static String SUBMIT_ADDPOST_XPATH = "//input[@test-id='submit-addpost']";
    private static String TITLE_ADDPOST_XPATH = "//input[@test-id='addpost-title']";
    private static String CONTENT_ADDPOST_XPATH = "//textarea[@test-id='addpost-content']";
    private static String TITLE_XPATH = "//*[@id=\"main\"]/div[1]/h3*']";

    public static void go(){
        Driver.driver.navigate().to(FULL_ADDPOST);
    }

    public static boolean at(){
        boolean result = false;
        result = (Driver.driver.getCurrentUrl().toString().equals(FULL_ADDPOST) &&
                Elements.isFoundAndDisplayed(By.xpath(SUBMIT_ADDPOST_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(TITLE_ADDPOST_XPATH)) &&
                Elements.isFoundAndDisplayed(By.xpath(CONTENT_ADDPOST_XPATH)))
                ? true :false;
        return result;
    }

    public static void addPost (String title, String content){
        WebElement titleElement = Elements.getElement(By.xpath(TITLE_ADDPOST_XPATH));
        if (titleElement != null) {titleElement.sendKeys(title);}
        WebElement contentElement = Elements.getElement(By.xpath(CONTENT_ADDPOST_XPATH));
        if (contentElement != null) {
            contentElement.sendKeys(content);
            contentElement.submit();
        }
    }

    public static boolean getAddPostStatus(){
        if ( Elements.isFoundAndDisplayed(By.id("error_message")) == true ){
            return false;
        }
        WebElement postTitlesList = Elements.getElement(By.xpath(TITLE_XPATH));
        System.out.println("Titles:" + postTitlesList);
        return true;
//        if ( Elements.isFoundAndDisplayed(By.id("message")) != true ){
//            return false;
//        }
//        WebElement message = Elements.getElement(By.id("message"));
//        if (message.getText().contains("was successfully registered")){
//            return true;
//        }else {
//            return false;
//        }
    }
}
