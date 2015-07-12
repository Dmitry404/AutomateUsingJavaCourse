package com.example.blogsources.demotest.Tests;

import com.example.blogsources.demotest.Actions.LoginPage;
import com.example.blogsources.demotest.Actions.LogoutPage;
import com.example.blogsources.demotest.dataProviders.loginDataProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import org.testng.annotations.Test;

import static com.example.blogsources.URLMap.URLMap.FULL_URL;
import static com.example.blogsources.demotest.Driver.driver;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test(groups = "init")
public class init {
    @Test
    public void isAppAvailable() throws Exception{
        driver.navigate().to(FULL_URL);

        WebClient webClient = new WebClient();
        int statusCode = webClient.getPage(FULL_URL).getWebResponse().getStatusCode();
        assertThat(statusCode, is(SC_OK));
    }
}