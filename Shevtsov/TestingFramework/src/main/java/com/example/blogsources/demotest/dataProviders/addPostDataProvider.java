package com.example.blogsources.demotest.dataProviders;

import org.testng.annotations.DataProvider;

public class addPostDataProvider {
    @DataProvider(name = "getAddPostDataProvider")
    public static Object [][] getAddPostDataProvider(){
        return new Object[][]{
//                {"admin", "1",  null,null, false},
                {"admin", "1", "title1","content 1", true, true},
                {"guest", "1", "title2","content 2", false, false},
                {"admin", "1", "title3","content 3", true, true},
        };
    }
}
