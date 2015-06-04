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

package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import demo.services.WebBlogService;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    WebBlogService webBlogService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "about";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(){
        List<Post> posts = webBlogService.getAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public ModelAndView ModelAndView(){
        return new ModelAndView("addPost", "command", new Post());
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") Post post){
        webBlogService.addPost(post);
        List<Post> posts = webBlogService.getAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        List<Post> posts = webBlogService.getAllPosts();
        return new ModelAndView("webBlog", "posts", posts);
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView getPost(@RequestParam("postTitle") String postTitle){
        Post post = webBlogService.getPostByTitle(postTitle);
        return new ModelAndView("post", "post", post);
    }



}
