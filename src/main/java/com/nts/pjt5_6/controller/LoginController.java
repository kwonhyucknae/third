package com.nts.pjt5_6.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/bookingLogin")
public class LoginController {

	@GetMapping
	public String bookingLoginConvert() {
		
		return "bookinglogin";
	}
	

	@PostMapping
	public String login(@RequestParam(name = "login_email", required = true) String loginEmail, HttpServletResponse response) {
		Cookie cookie = new Cookie("loginEmail", loginEmail);
		cookie.setMaxAge(-1); 
		cookie.setPath("/"); 
		response.addCookie(cookie);
		
		return "redirect:myreservation";
	}
}
