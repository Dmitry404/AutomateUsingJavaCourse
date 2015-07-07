package demotest;

import org.openqa.selenium.By;

import static demo.Page.URLMap.*;
import static demotest.Driver.driver;

public class LoginPage {
    public static void go(){
        driver.navigate().to(FULL_LOGIN);
    }

    public static boolean at(){
        if ( driver.findElement(By.xpath("//input[@test-id='submit-login']")) != null ) {
            return true;
        }else{
            return false;
        }
    }
}
