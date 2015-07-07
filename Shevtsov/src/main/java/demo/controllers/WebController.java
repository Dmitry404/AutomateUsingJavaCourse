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
import demo.Users.BasicUser;
import demo.Users.User;
import demo.Users.UsersInRam;
import demo.services.PostStorage;
import demo.services.PostsInRam;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static demo.Page.URLMap.*;

// TODO
// Add log4j
// Add DB
// Add Spring Security
// Add REST API
// Add i18n

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    @Qualifier("postStorage")
    PostStorage postStorage;

    @Autowired
    @Qualifier("users")
    UsersInRam users;

    @PostConstruct
    public void initIt() throws Exception {
        User user = new BasicUser("admin", 0);
        if (!users.userNameExists(user.getUserName())){
            user.setPassword("1");
            user.setEmail("admin@example.com");
            users.addNewUser(user);
            System.out.println("Add user admin");
        }

        User guest = new BasicUser("guest", 3);
        if (!users.userNameExists(guest.getUserName())){
            guest.setPassword("1");
            guest.setEmail("guest@example.com");
            users.addNewUser(guest);
            System.out.println("Add user guest");
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "welcome";
    }

    @RequestMapping(value = ABOUT, method = RequestMethod.GET)
    public String about(){
        return "about";
    }

    @RequestMapping(value = WELCOME, method = RequestMethod.GET)
    public ModelAndView welcome(){
        List<Post> posts = postStorage.displayAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }

    @RequestMapping(value = ADDPOST, method = RequestMethod.GET)
    public ModelAndView addPost(){
        return new ModelAndView("addPost", "command", new RegularPost());
    }

    @RequestMapping(value = ADDPOST, method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") RegularPost post){
        ModelAndView modelAndView = new ModelAndView();
        if (post == null){
            modelAndView.addObject("error_message", "The object post is NULL!!!");
            modelAndView.setViewName("error");
            return modelAndView;
        }
//        System.out.println("This is addPost in WebController. Title - " + post.getPostTitle() + " Content: " + post.getPostContent());
        postStorage.addNewPost(post);
        List<Post> posts = postStorage.displayAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }


    @RequestMapping(value = REGISTER, method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("register", "command", new BasicUser());
    }

    @RequestMapping(value = REGISTER, method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") BasicUser user){
        ModelAndView modelAndView = new ModelAndView();
        if (user == null){
            modelAndView.addObject("error_message", "The object user is NULL!!!");
            modelAndView.setViewName("error");
            return modelAndView;
        }
        users.addNewUser(user);
        modelAndView.addObject("message", "Id: "+ users.getUserId(user.getUserName())+" Name : " + user.getUserName() + " Password: "+user.getPassword() + " email: "+ user.getEmail());
        modelAndView.setViewName("message");
        return modelAndView;
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


    @RequestMapping(value = LOGIN, method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login", "command", new BasicUser());
    }


    @RequestMapping(value = LOGIN, method = {RequestMethod.POST})
    public ModelAndView login(@ModelAttribute("user") BasicUser user, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if (user == null){
            modelAndView.addObject("error_message", "The object user is NULL!!!");
            modelAndView.setViewName("error");
            return modelAndView;
        }
        if (users.validateUser(user)){
            modelAndView.addObject("message", "Log in successful.");
//            modelAndView.addObject("message", "Log in successful. Id: " + users.getUserId(user.getUserName()) + " Name : " + user.getUserName() + " Password: " + user.getPassword() + " email: " + user.getEmail());
            HttpSession ses = request.getSession();
            ses.setAttribute("currentUser", users.getUserByName(user.getUserName()));
            modelAndView.setViewName("message");
            return modelAndView;
        }else{
//            modelAndView.addObject("error_message", "Login failed: " + " Name : " + user.getUserName() + " Password: " + user.getPassword() + " email: " + user.getEmail());
            modelAndView.addObject("error_message", "Login failed. Please enter correct user and password.");
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    @RequestMapping(value = LOGOUT, method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        {
            request.getSession().removeAttribute("currentUser");
            request.getSession().invalidate();
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", "Log Out successful");
            modelAndView.setViewName("message");
            return modelAndView;
        }
    }


}
