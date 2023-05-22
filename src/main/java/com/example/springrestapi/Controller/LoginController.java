package com.example.springrestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestapi.Model.User;
import com.example.springrestapi.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	// method 1
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String postLogin(@RequestParam String firstname, @RequestParam String lastname, ModelMap model) {
		model.put("firstname", firstname);
		model.put("lastname", lastname);
		String res = userService.saveUser(new User(firstname,lastname));
		model.put("message", res);
		return "login";
	}
	// method 2
//	@RequestMapping(value = "login", method=RequestMethod.POST)
//	public String postLogin(@ModelAttribute("user") User user, BindResult result, ModelMap model) {
//		String res = userService.saveUser(user);
////		model.addAttribute("user", new User());
//		
////		model.put("message", res);
//		return "login";
//	}
	// method 3
//	@RequestMapping(value = "login", method=RequestMethod.POST)
//	public String postLogin(ModelMap model, User user) {
//		String res = userService.saveUser(new User(user.getFirstname(),user.getLastname()));
////		model.addAttribute("user", new User());
//		
////		model.put("message", res);
//		return "login";
//	}
	
	@GetMapping("display")
	public String displayPage(ModelMap model) {
		List<User> user = userService.findAll();
		model.put("users", user);
		return "home";
	}
}
