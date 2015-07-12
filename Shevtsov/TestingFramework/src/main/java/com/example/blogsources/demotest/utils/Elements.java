package com.example.blogsources.demotest.utils;

import com.example.blogsources.demotest.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Elements {
    public static boolean isFoundAndDisplayed (By by){
        WebElement element = null;
        try {
            element = Driver.driver.findElement(by);;
            return (element != null && element.isDisplayed()) ? true : false;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public static WebElement getElement (By by){
        return (isFoundAndDisplayed(by)) ? Driver.driver.findElement(by) : null;
    }

}
