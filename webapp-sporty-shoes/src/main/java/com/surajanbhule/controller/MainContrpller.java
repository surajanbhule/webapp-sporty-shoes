package com.surajanbhule.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	public String home(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(path = "/admin")
	public String admin(HttpServletRequest request) {
		return "admin";
	}
	
	@RequestMapping(path = "/login")
	public String login(HttpServletRequest request) {
		
		return "login";
	}
	
	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session= request.getSession();
		session.removeAttribute("current-user");
		return "redirect:/login";
	}

	@RequestMapping(path = "/register")
	public String register(HttpServletRequest request) {
		return "register";
	}

	@PostMapping("/process-register")
	public String processRegister(@ModelAttribute User user, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			user.setUser_type("normal");
			User save = userRepository.save(user);

			if (save.getUser_id() > 0) {
				session.setAttribute("messege",
						"Registration successfull, username: " + save.getUsername() + " You can login.");
				session.setAttribute("msg_type","success");
			} else {
				session.setAttribute("messege", "Something went wrong");
				session.setAttribute("msg_type","danger");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/login";
	}

	@PostMapping("/login-process")
	public String processLogin(@Param("username") String username, @Param("password") String password,
			HttpServletRequest request) {
		
		HttpSession session= request.getSession();
		
		User user = userRepository.findByUsernameAndPassword(username, password);

		if (user == null) {

		} else if (user.getUser_type().equals("normal")) {
			session.setAttribute("current-user", user);
			return "redirect:/";

		} else if (user.getUser_type().equals("admin")) {
			session.setAttribute("current-user", user);
			return "redirect:admin";

		} else {

		}

		return "login";
	}
}
