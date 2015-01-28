package sample.jsp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "post")
public class WelcomeController {

	@Autowired
	private PostServiceImpl postService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView getLogin(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping("registration")
	public String registration(Map<String, Object> model) {
		return "registration";
	}

	@RequestMapping("about")
	public String about(Map<String, Object> model) {
		return "about";
	}

	@RequestMapping("contact")
	public String contact(Map<String, Object> model) {
		return "contact";
	}


	@RequestMapping(value = "viewAllPost", method = RequestMethod.GET)
	public ModelAndView viewAllPost(){
	    ModelAndView rtv = new ModelAndView();
		rtv.setViewName("postViewAll");
		rtv.addObject("posts", postService.getAllPosts());
		return rtv;
	}
	
	@RequestMapping(value = "fillPost", method = RequestMethod.GET)
	public ModelAndView newPost(){
		ModelAndView rtv = new ModelAndView();
		rtv.setViewName("newPost");
		rtv.addObject("post", new Post());
		return rtv;
	}

	@RequestMapping(value = "addPost", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "post") Post post){
	postService.addPost(post);
		return "redirect:viewAllPost";
	}

	@RequestMapping(value = "/topic/{title}", method = RequestMethod.GET)
	public String getTopicById(HttpServletRequest request, @PathVariable("title") String title){
		request.setAttribute("topic", postService.getByTitle(title));
		return "topic";
	}

}

