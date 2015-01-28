package sample.jsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver {

        private static WebDriver driver;

        public static WebDriver getInstance() {
            if (driver == null)
                driver = new FirefoxDriver();
            return driver;
        }

    public static void closeBrowser() {
        driver.quit();
    }


}

