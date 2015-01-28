package sample.jsp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class addNewPost {

    public static WebElement findWebElementInAddNewPostPage(By by) {
        return driver.getInstance().findElement(by);
    }

}
