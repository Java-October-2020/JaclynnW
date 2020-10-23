package com.jaclynn.hellohuman.humancontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {


	@RequestMapping("/{name}")
	public String hello(@RequestParam(value="name", required=false, defaultValue="Human") String printName, Model model) {
		if(printName.equals(null)) {
			model.addAttribute("name", "Human");
		}
		else {
			model.addAttribute("name", printName);
		}
		return "index.jsp";
	}//this function does not work properly either. with or without a parameter it prints "Human"


	//Solution - doesn't work with a name when the index.jsp file has <c:out value="${name}"/> why?
//	@RequestMapping("/")
//	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="Human") String name) {
//		model.addAttribute("name", name);
//		return "index.jsp";
//	}
}
