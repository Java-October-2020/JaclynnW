package com.jaclynn.routing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingControler {
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String python() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/coding/java")
	public String java() {
		return "Java/Spring is better!";
	}

}
