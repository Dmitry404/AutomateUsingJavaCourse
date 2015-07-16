package com.example.blogsources.demotest.Tests;

import com.example.blogsources.demotest.Actions.LoginPage;
import com.example.blogsources.demotest.Actions.LogoutPage;
import com.example.blogsources.demotest.dataProviders.loginDataProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static com.example.blogsources.URLMap.URLMap.*;

import static com.example.blogsources.demotest.Driver.driver;
import static org.apache.http.HttpStatus.*;

@Test(dependsOnGroups = "init")
public class loginLogout {

    @Test (groups = { "sanity", "login" })
    public void isLoginPageAvailable(){
        LoginPage.go();
        assertThat(LoginPage.at(), is(true));
    }

    @Test (groups = { "sanity", "logout" })
    public void isLogoutPageAvailable(){
        LogoutPage.go();
        assertThat(LogoutPage.at(), is(true));
    }

    @Test(dataProvider = "getLoginDataProvider", dataProviderClass = loginDataProvider.class,
            dependsOnMethods = { "isLoginPageAvailable" },
            groups = { "login" },
            timeOut = 3000)
    public void testLogin(String username, String password, boolean expected){
        LoginPage.go();
        assertThat(LoginPage.isLoggedIn(), is(false));
        LoginPage.login(username, password);
        assertThat(LoginPage.isLoggedInAs(username), is(expected));
        logout();
    }

    private void logout(){
        LogoutPage.logout();
        assertThat(LogoutPage.isLoggedOut(), is (true));
    }
}