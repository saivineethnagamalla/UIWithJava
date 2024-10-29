package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UserData {
	
	@NotNull(message = "age should not be null")
	@Min(value = 18, message = "age should be mininum 18")
	private Integer age;
	private String name;
	private String email;
	
	
	
	
	
	@Override
	public String toString() {
		return "UserData [age=" + age + ", name=" + name + ", email=" + email + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
