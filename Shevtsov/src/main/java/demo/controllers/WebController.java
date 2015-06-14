/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.controllers;

import java.util.List;

import demo.Page.Post;
import demo.Page.RegularPost;
import demo.services.PostStorage;
import demo.services.PostsInRam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    @Qualifier("postStorage")
    PostStorage postStorage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "welcome";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(){
        return "about";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(){
        List<Post> posts = postStorage.displayAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public ModelAndView ModelAndView(){
        return new ModelAndView("addPost", "command", new RegularPost());
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") RegularPost post){
        ModelAndView modelAndView = new ModelAndView();
        if (post == null){
            modelAndView.addObject("error_message", "The object post is NULL!!!");
            modelAndView.setViewName("error");
            return modelAndView;
        }
        System.out.println("This is addPost in WebController. Title - " + post.getPostTitle() + " Content: " + post.getPostContent());
        postStorage.addNewPost(post);
        List<Post> posts = postStorage.displayAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        List<Post> posts = postStorage.displayAllPosts();
        Post post = posts.get(posts.size() - 1);
        System.out.println("The amount of posts: " + posts.size());
        System.out.println("The last one. Title - " + post.getPostTitle() + "Content: " + post.getPostContent());
        return new ModelAndView("webBlog", "posts", posts);
    }

//    @RequestMapping(value = "/post", method = RequestMethod.GET)
//    public ModelAndView getPost(@RequestParam("postTitle") String postTitle){
//        PostFromDemo post = postStorage.getPostByTitle(postTitle);
//        return new ModelAndView("post", "post", post);
//    }



}
