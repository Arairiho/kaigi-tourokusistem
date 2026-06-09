package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class KaigiController {
	private final UserRepository userRepository;

	public KaigiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/sinki")
	public String sinki() {
		return "sinki";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam String name,
			@RequestParam String mail,
			@RequestParam String pass) {

		User user = new User(name, mail, pass);
		userRepository.save(user);

		return "login";
	}

	@PostMapping("/main")
	public String main(
			@RequestParam String mail,
			@RequestParam String pass) {

		User user = null;
		user = userRepository.findByEmailAndPassword(mail, pass);

		if (user == null) {
			return "login";
		} else {

			return "main";

		}
	}
}
