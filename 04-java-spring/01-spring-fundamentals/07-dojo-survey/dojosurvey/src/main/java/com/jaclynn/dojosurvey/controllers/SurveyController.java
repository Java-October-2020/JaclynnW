package com.jaclynn.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@GetMapping("/")
	public String survey() {
		return "SurveyHome.jsp";
	}
	
	@PostMapping("/")
	public String submitResults(@RequestParam(value="name") String name, @RequestParam(value="dojo") String dojo, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("dojo", dojo);
		viewModel.addAttribute("language", language);
		viewModel.addAttribute("comment", comment);
		return "result.jsp";
	}
	@GetMapping("/result")
	public String results(Model viewModel) {
//		viewModel.getAttribute(name);
//		viewModel.getAttribute(dojo);
//		viewModel.getAttribute(language);
//		viewModel.getAttribute(comment);
		return "result.jsp";
	}
	@PostMapping("/result")
	public String goBack() {
		return "SurveyHome.jsp";
	}

}
