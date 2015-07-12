package com.example.blogsources.demotest.dataProviders;

import org.testng.annotations.DataProvider;

public class registrationDataProvider {
    @DataProvider(name = "getRegistrationDataProvider")
    public static Object [][] getRegistrationDataProvider(){
        return new Object[][]{
                {null,null,null, false},
//                {"IncorrectEmail","User","1", false},
                {"existedUser@example.com","admin","1", false},
                {"newuser@example.com","newuser","111", true},
        };
    }
}
