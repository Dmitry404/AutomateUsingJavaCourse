package demotest;

import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static demo.Page.URLMap.*;

import static demotest.Driver.driver;
import static org.apache.http.HttpStatus.*;

public class loginLogout {

    @Test(groups = { "sanity" })
    public void isAppAvailable() throws Exception{
        driver.navigate().to(FULL_URL);

        WebClient webClient = new WebClient();
        int statusCode = webClient.getPage(FULL_URL).getWebResponse().getStatusCode();
        assertThat(statusCode, is(SC_OK));
    }

    @Test (dependsOnMethods = { "isAppAvailable" }, groups = { "sanity", "login" })
    public void isLoginPageAvailable(){
        LoginPage.go();
        assertThat(LoginPage.at(), is(true));
    }

    @Test (dependsOnMethods = { "isAppAvailable" }, groups = { "sanity", "logout" })
    public void isLogoutPageAvailable(){
        LogoutPage.go();
        assertThat(LogoutPage.at(), is(true));
    }

    @Test(dataProvider = "getLoginDataProvider", dataProviderClass = demotest.dataProviders.loginDataProvider.class,
            dependsOnMethods = { "isLoginPageAvailable" },
            groups = { "login" },
            timeOut = 3000)
    public void testLogin(String username, String password, boolean expected){
        LoginPage.go();
        if (LoginPage.isLoggedIn()){
            assert false;
        }
        LoginPage.login(username, password);
        assertThat(LoginPage.isLoggedInAs(username), is(expected));
    }


    @Test(dependsOnMethods = { "testLogin" },
            groups = { "login", "logout" })
    public void logout(){
        LogoutPage.logout();
        assertThat(LogoutPage.isLoggedOut(), is (true));
    }
}