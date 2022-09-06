package com.surajanbhule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContrpller {

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
	public String processRegister() {
		
		return "login";
	}
}
