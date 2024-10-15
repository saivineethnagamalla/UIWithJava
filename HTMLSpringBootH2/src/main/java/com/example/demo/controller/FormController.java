package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserRepository;

@Controller
public class FormController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("user", new UserInfo());
		return "form";
	}

	@PostMapping("/submitForm")
	public String submitForm(@ModelAttribute UserInfo user, Model model) {
		userRepository.save(user);
		model.addAttribute("user", user);
		return "result";
	}

	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
}
