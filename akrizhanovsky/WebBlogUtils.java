package com.javacourses.homework1;

import java.util.List;
import java.util.Random;

public class WebBlogUtils {

    public void printList(List<String> list) {
        for (int i=0; i<list.size(); i++) System.out.print("\"" + list.get(i) + "\" ");
        System.out.println();
    }

    public int createPostId() {
        Random rand = new Random();
        int postId = rand.nextInt((99999 - 10000) + 1) + 10000;
        return postId;
    }

    public String getRandomStringArrayItem(String[] array) {
        String random = (array[new Random().nextInt(array.length)]);
        return random;
    }

}
