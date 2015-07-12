package com.example.blogsources.demotest.Tests;

import com.example.blogsources.demotest.Actions.AddPostPage;
import com.example.blogsources.demotest.Actions.LoginPage;
import com.example.blogsources.demotest.Actions.LogoutPage;
import com.example.blogsources.demotest.Actions.RegistrationPage;
import com.example.blogsources.demotest.dataProviders.addPostDataProvider;
import com.example.blogsources.demotest.dataProviders.registrationDataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test(dependsOnGroups = {"init", "login"})
public class addPost {

    private boolean isAddPagePageAvailable(){
        AddPostPage.go();
        return AddPostPage.at();
    }

    @Test(dataProvider = "getAddPostDataProvider", dataProviderClass = addPostDataProvider.class,
            groups = { "addPost" },
            timeOut = 3000)
    public void testRegistration(String username, String password, String title, String content, boolean isAddPageAvailable, boolean expected){
        LoginPage.go();
        LoginPage.login(username, password);
        assertThat(LoginPage.isLoggedInAs(username), is(true));
        assertThat(isAddPagePageAvailable(), is(isAddPageAvailable));
        if (isAddPageAvailable) {
            AddPostPage.addPost(title, content);
            assertThat(AddPostPage.getAddPostStatus(), is(expected));
        }
    }
}