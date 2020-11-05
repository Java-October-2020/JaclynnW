package com.jaclynn.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.jaclynn.languages.models.Language;
import com.jaclynn.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public String home(Model viewModel, @ModelAttribute("languages") Language newLanguage) {
		List<Language> languages = this.lService.getAllLanguages();
		viewModel.addAttribute("allLanguages", languages);
		return "home.jsp";
	}
	@PostMapping("/")
	public String addNewLanguage(@Valid @ModelAttribute("languages") Language newLanguage, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		else {
			this.lService.createLanguage(newLanguage);
			return "redirect:/";
		}
	}
	@GetMapping("/edit/{id}")
	public String updateLanguage(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("language") Language language) {
		viewModel.addAttribute("language", this.lService.getOneLanguage(id));
		return "edit.jsp";
	}
	@PutMapping("/edit/{id}")
	public String editedLanguage(@Valid @ModelAttribute("language") Language editedlanguage, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			this.lService.updateLanguage(editedlanguage);
			return "redirect:/";
		}
	}
	@GetMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/";
	}

}
