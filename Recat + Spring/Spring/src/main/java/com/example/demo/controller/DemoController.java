package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
@CrossOrigin("http://localhost:3000/")
public class DemoController {
	
	
	@GetMapping("/")
	public String test()	{
		return "weclome to spring boot";
	}
	
	@PostMapping("/posting")
	public UserData test(@RequestBody @Valid UserData check) {
		return check;
		
	}

}