package com.jaclynn.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("errors") String errors) {
		return "theCode.jsp";
	}
	
	@PostMapping("/")
	public String codeCheck(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
		String correctCode = "bushido";
		if(code.equals(correctCode)) {
			return "secretPage.jsp";
		}
		else {
			redirectAttributes.addFlashAttribute("errors","You must train harder!");
			return "redirect:/";
		}
		
	}
	@GetMapping("/code")
	public String secretPage() {
		return "secretPage.jsp";
	}
	@PostMapping("/code")
	public String secrets() {
		return "secretPage.jsp";
	}


}
