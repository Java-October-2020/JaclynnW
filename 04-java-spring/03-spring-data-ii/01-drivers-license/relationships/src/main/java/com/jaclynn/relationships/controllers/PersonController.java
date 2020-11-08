package com.jaclynn.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaclynn.relationships.models.License;
import com.jaclynn.relationships.models.Person;
import com.jaclynn.relationships.services.LicenseService;
import com.jaclynn.relationships.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonService pService;
	@Autowired
	private LicenseService lService;
	
	@GetMapping("/new")
	public String index(@ModelAttribute("person") Person person) {
		return "addperson.jsp";
	}
	@PostMapping("/new")
	public String addNewPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "addperson.jsp";
		}
		else {
			this.pService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	@GetMapping("/{id}")
	public String showLicense(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("person")Person person) {
		viewModel.addAttribute("person", this.pService.getOnePerson(id));
		return "show.jsp";
	}
	
}
