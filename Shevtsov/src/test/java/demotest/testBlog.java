package demotest;

import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static demo.Page.URLMap.*;

import static demotest.Driver.driver;
import static org.apache.http.HttpStatus.*;

public class testBlog {

    @Test
    public void isAppAvailable() throws Exception{
        driver.navigate().to(FULL_URL);

        WebClient webClient = new WebClient();
        int statusCode = webClient.getPage(FULL_URL).getWebResponse().getStatusCode();
        assertThat(statusCode, is(SC_OK));
    }

    @Test
    public void checkLoginPage(){
        LoginPage.go();
        assertThat(LoginPage.at(), is(true));
    }
}