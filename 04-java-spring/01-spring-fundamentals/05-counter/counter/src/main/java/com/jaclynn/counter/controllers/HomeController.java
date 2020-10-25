package com.jaclynn.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	private int counterPage(HttpSession session) {
		int sessionCount = (int) session.getAttribute("count");
		if(session.getAttribute("count") == null) {
			sessionCount = 0;

		}
		return (int)sessionCount;

	}
	@GetMapping("/")
	public String home(HttpSession session) {
		int counter = counterPage(session) + 1;
		session.setAttribute("count", counter);
		return "homecounter.jsp";
	}


	@GetMapping("/counter")
	public String increaseCount(HttpSession session, Model viewModel) {
		session.getAttribute("count");
		return "counter.jsp";
		
	}
}
