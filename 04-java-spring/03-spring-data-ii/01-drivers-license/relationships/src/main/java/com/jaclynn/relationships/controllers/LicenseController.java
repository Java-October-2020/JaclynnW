package com.jaclynn.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaclynn.relationships.models.License;
import com.jaclynn.relationships.models.Person;
import com.jaclynn.relationships.services.LicenseService;
import com.jaclynn.relationships.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	@Autowired
	private LicenseService lService;
	
	@Autowired
	private PersonService pService;
	
	
	@GetMapping("/new")
	public String index(@ModelAttribute("license") License license, Model viewModel) {
		List<Person> unlicensed = pService.getUnlicensedPerson();
		viewModel.addAttribute("persons", unlicensed);
		return "newlicense.jsp";
	}
	
	@PostMapping("/new")
	public String addNewLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newlicense.jsp";
		}
		else {
			this.lService.createLicense(license);
			return "redirect:/persons/new";
		}
	}
}
