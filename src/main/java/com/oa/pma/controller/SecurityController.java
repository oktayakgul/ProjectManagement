package com.oa.pma.controller;

import com.oa.pma.entity.UserAccount;
import com.oa.pma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
	
	@Autowired
	BCryptPasswordEncoder cryptPasswordEncoder;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String register(Model model){
		UserAccount user = new UserAccount();
		model.addAttribute("newUserAccount", user);
		
		return "security/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(Model model, UserAccount user){
		user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));
		
		userService.save(user);
		return "redirect:/"; /// when we redirect like this, we need to have CSRF protection, spring security libs provide that csrf production
	}
}
