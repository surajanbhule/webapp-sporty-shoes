package com.surajanbhule.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surajanbhule.entities.User;
import com.surajanbhule.repositories.UserRepository;

@Controller
public class MainContrpller {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(path = "/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/process-register")
	public String processRegister(@ModelAttribute User user,HttpServletRequest request) {
		try {
			HttpSession session =request.getSession();
			user.setUser_type("normal");
			User save = userRepository.save(user);
			
			if(save.getUser_id()>0)
			{
				session.setAttribute("messege", "Registration successfull, username: "+save.getUsername()+" You can login.");
			}
			else {
				session.setAttribute("messege", "Something went wrong");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "redirect:/login";
	}
}
