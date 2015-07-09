package demotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import ru.stqa.selenium.factory.WebDriverFactory;

public class Driver {
    public static WebDriver driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
//    public static WebDriver driver = new FirefoxDriver();

//    @AfterSuite
//    public void stopAllDrivers() {
////        WebDriverFactory.dismissAll();
//        driver.quit();
//    }
}
