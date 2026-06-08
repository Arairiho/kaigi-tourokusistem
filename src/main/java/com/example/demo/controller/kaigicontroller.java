package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class kaigicontroller {

	@GetMapping("/sinki")
	public String sinki() {
		return "sinki";
	}

	@PostMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/main")
	public String main() {
		return "main";
	}
}
