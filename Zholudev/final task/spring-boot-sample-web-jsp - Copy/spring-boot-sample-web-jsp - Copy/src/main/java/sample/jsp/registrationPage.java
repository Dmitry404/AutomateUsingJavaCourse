package sample.jsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class registrationPage {

    public static void goTo() {
        driver.getInstance().navigate().to("http://localhost:8080/post/registration");
    }

    public static WebElement findWebElementInRegistrationPage(By by) {
        return driver.getInstance().findElement(by);
    }

}
