package demotest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static demotest.Driver.driver;

public class Elements {
    public static boolean isFoundAndDisplayed (By by){
        WebElement element = null;
        try {
            element = driver.findElement(by);;
            return (element != null && element.isDisplayed()) ? true : false;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public static WebElement getElement (By by){
        return (isFoundAndDisplayed(by)) ? driver.findElement(by) : null;
    }

}
