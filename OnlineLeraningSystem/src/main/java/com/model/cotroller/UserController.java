package com.model.cotroller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Message;
import com.model.User;
import com.model.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	// home handler
	@GetMapping("/")
	public String homePage(Model m) {
		m.addAttribute("title", "Home-OLS");
		return "index";
	}
	
	//about page
	@GetMapping("/about")
	public String aboutPage(Model m) {
		m.addAttribute("title", "About - OLS");
		return "about";
	}
	
	// register the user
	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("title", "Register - OLS");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	// handler for regirstering user
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult bindingResult,Model model,  HttpSession session) {
		
		
		try {
			if(bindingResult.hasErrors()) {
				System.out.println("Error :"+bindingResult);
				return "signup";
			}
			service.saveUser(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered !! ", "alert - success"));
			System.out.println("USer :"+user);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Someting Went Wrong!! "+e.getMessage(), "alert - danger"));
			
		}
		return "signup";
	}
	
	
	
	// custom login page handler
	@GetMapping("/signin")
	public String loginPage(Model m) {
		
		m.addAttribute("title", "Login Page - OLS");
		return "login";
	}
	
}
