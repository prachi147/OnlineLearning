package com.model.cotroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.model.Repository.UserRepository;


@Controller
@RequestMapping("/user")public class HomeController {

	@Autowired
	UserRepository repository;
	
	// used to show the user dashboard
	@GetMapping("/index")
	public String dashboard(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("USERNAME : "+userName);
		
		
		// get the user using username ---> email
		User user = repository.getUserByUserName(userName);
		System.out.println("User "+user);
		
		model.addAttribute("user", user);
		
		return "normal/user_dashboard";
	}
	
	
	
	
}
