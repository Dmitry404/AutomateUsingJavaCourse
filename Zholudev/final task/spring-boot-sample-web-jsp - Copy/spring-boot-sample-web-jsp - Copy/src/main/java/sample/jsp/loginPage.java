package sample.jsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage {



        public static void goTo() {
            driver.getInstance().navigate().to("http://localhost:8080/post/login");
        }

       public static WebElement email() {
                return driver.getInstance().findElement(By.id("inputEmail"));
        }
       public static WebElement password() {
                return driver.getInstance().findElement(By.id("inputPassword"));
        }
       public static WebElement submit() {
                return driver.getInstance().findElement(By.xpath("html/body/div[1]/form/button"));
        }

       public static WebElement findWebElementInLoginPage(By by) {
                return driver.getInstance().findElement(by);
        }

        public static EnterCredentials login(String username) {
                return new EnterCredentials(username);
        }

        static class EnterCredentials {
                private String username;

                public EnterCredentials(String username) {
                        this.username = username;
                }

                public void withPassword(String password) {
                        email().sendKeys(username);
                        password().sendKeys(password);
                        submit().click();
                }
        }

        public static void enterMainPage() {
                goTo();
                login("any@any.any")
                        .withPassword("any");
                mainForumPage.waitForWebElementToBeClickable(By.linkText("Spring forum"));
        }



}
