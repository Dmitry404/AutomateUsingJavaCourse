package com.example.blogsources.demotest.Tests;

import com.example.blogsources.demotest.Actions.LoginPage;
import com.example.blogsources.demotest.Actions.LogoutPage;
import com.example.blogsources.demotest.Actions.RegistrationPage;
import com.example.blogsources.demotest.dataProviders.loginDataProvider;
import com.example.blogsources.demotest.dataProviders.registrationDataProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import org.testng.annotations.Test;

import static com.example.blogsources.URLMap.URLMap.FULL_URL;
import static com.example.blogsources.demotest.Driver.driver;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test(dependsOnGroups = {"init", "login"})
public class Registration {

    @Test (groups = { "sanity", "registration" })
    public void isRegistrationPageAvailable(){
        RegistrationPage.go();
        assertThat(RegistrationPage.at(), is(true));
    }

    @Test(dataProvider = "getRegistrationDataProvider", dataProviderClass = registrationDataProvider.class,
            dependsOnMethods = { "isRegistrationPageAvailable" },
            groups = { "registration" },
            timeOut = 3000)
    public void testRegistration(String email, String username, String password, boolean expected){
        RegistrationPage.go();
        assertThat(RegistrationPage.at(), is(true));
        RegistrationPage.register(email, username, password);
        assertThat(RegistrationPage.getRegistrationStatus(), is(expected));
        if (expected) {
            LoginPage.go();
            assertThat(LoginPage.isLoggedIn(), is(false));
            LoginPage.login(username, password);
            assertThat(LoginPage.isLoggedInAs(username), is(expected));
            LogoutPage.logout();
            assertThat(LogoutPage.isLoggedOut(), is(true));
        }
    }
}