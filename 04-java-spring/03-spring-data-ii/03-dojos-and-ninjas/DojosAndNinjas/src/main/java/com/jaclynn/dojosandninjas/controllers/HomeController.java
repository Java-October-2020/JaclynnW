package com.jaclynn.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaclynn.dojosandninjas.models.Dojo;
import com.jaclynn.dojosandninjas.models.Ninja;
import com.jaclynn.dojosandninjas.services.DojoNinjaService;

@Controller
public class HomeController {
	@Autowired
	private DojoNinjaService dnService;

	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "addDojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String addNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "addDojo.jsp";
		}
		else {
			this.dnService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@GetMapping("/ninjas/new")
	public String newNinjas(@ModelAttribute("ninjas") Ninja newNinja, Model viewModel) {
		viewModel.addAttribute("dojos", this.dnService.getAllDojos());
		return "addNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String addNewNinjas(@Valid @ModelAttribute("ninjas") Ninja newNinja, BindingResult result) {
		if(result.hasErrors()) {
			return "addNinja.jsp";			
		}
		else {
			this.dnService.createNinja(newNinja);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showNinjas(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("dojo", this.dnService.getOneDojo(id));
			return "show.jsp";
		}
	
}
