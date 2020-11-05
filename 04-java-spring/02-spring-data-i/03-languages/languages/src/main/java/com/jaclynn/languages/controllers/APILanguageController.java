package com.jaclynn.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaclynn.languages.models.Language;
import com.jaclynn.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APILanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public List<Language> index(){
		return this.lService.getAllLanguages();
	}
	@GetMapping("/{id}")
	public Language getLanguage(@PathVariable("id")Long id) {
		return this.lService.getOneLanguage(id);
	}
	@PutMapping("/language/update/{id}")
	public Language edit(@PathVariable("id") Long id, Language updatedLanguage) {
		return this.lService.updateLanguage(updatedLanguage);
	}
	@PostMapping("")
	public Language create(Language newLanguage) {
		return this.lService.createLanguage(newLanguage);
	}
	@DeleteMapping("langauge/delete/{id}")
	public void removeLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
	}
	

}
