package com.lohika.AutomateUsingJavaCourse.Shevtsov.WebBlog.Page;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PagesInRam implements PageStorage {
    private List<Page> pages = new ArrayList<>();

    public void addNewPage (String type, String content,int userId) {
        switch (type){
            case "regular": //System.out.println("Add a new regular page #" + pages.size() + " and userId = " + userId+ "\n" + "Content:" + content+"\n");
                            pages.add(new RegularPage(pages.size(), content, userId));
                            break;
            case "url": pages.add( new URLPage(pages.size(), content, userId));
                            break;
            case "image": pages.add( new ImagePage(pages.size(), content, userId));
                            break;
            default:
                throw new IllegalArgumentException("Invalid type of the page: " + type + "Expected values regular/url/image");
        }
    }

    public void removePage (int id) {
        pages.remove(id);
    }

    public void displayPage (int id, PrintStream out) {
//        out.println("try to get page #"+id + " " + pages.get(id).getPageType() + " "  + pages.get(id).getPageCreationDate() + "\n");
        pages.get(id).displayPage(out);
    }

    @Override
    public void displayAllPages(PrintStream out) {
        for (Page page : pages){
            page.displayPage(out);
        }
    }

}
