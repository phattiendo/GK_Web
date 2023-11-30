package com.phatvo.economic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phatvo.economic.services.CookieService;
import com.phatvo.economic.services.ParamService;
import com.phatvo.economic.services.SessionService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	CookieService cookieService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String postLogin() {
		// Get parameter use param service
		String username = paramService.getString("username", "");
		String password = paramService.getString("password", "");
		boolean remember = paramService.getBoolean("remember", false);
		// Save username into session
		sessionService.set("username", username);
		// Save username and password into cookie
		if (remember) {
			cookieService.add("username", username, 1);
			cookieService.add("password", password, 1);
			cookieService.add("remember", remember+"", 1);
		} else {
			cookieService.remove("username");
			cookieService.remove("password");
			cookieService.remove("remember");
		}
		return "redirect:/products";
	}

	@GetMapping("/logout")
	public String getLogout() {
		sessionService.remove("username");
		return "redirect:/products";
	}
	
}
