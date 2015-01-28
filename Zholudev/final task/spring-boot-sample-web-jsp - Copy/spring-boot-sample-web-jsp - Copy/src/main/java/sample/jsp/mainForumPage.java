package sample.jsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainForumPage {

    private static final int DEFAULT_ACTION_TIMEOUT = 10;


    public static WebElement addNewPost() {
        return driver.getInstance().findElement(By.xpath(".//*[@id='navbar']/ul/a"));
    }


    public static WebElement waitForWebElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver.getInstance(), DEFAULT_ACTION_TIMEOUT);
        WebElement webElement;
        return webElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    public static WebElement findWebElementInMainPage(By by) {
        return driver.getInstance().findElement(by);
    }


}
