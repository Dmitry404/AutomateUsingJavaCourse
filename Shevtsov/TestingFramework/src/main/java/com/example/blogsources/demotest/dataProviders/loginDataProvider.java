package com.example.blogsources.demotest.dataProviders;

import org.testng.annotations.DataProvider;

import java.util.Objects;

public class loginDataProvider {
    @DataProvider(name = "getLoginDataProvider")
    public static Object [][] getLoginDataProvider(){
        return new Object[][]{
                {null,null, false},
                {"NonExistedUser","1", false},
                {"admin","1", true},
                {"guest","1", true},
        };
    }
}
