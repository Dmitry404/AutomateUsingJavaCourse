package sample.jsp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "post")
public class WelcomeController {

	@Autowired
	private PostService postService;


	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
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

}
