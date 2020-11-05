package com.jaclynn.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.languages.models.Language;
import com.jaclynn.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository  lRepo;
	
	//Get all
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	// Get One
	public Language getOneLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//Create Language
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	
	public Language createLanguage(String name, String creator, String version) {
		Language newLanguage = new Language(name, creator, version);
		return this.lRepo.save(newLanguage);
	}
	
	//Update language
	public Language updateLanguage(Language updatedLanguage) {
		return this.lRepo.save(updatedLanguage);
	}
	// Delete Language
	public String deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
		return "Language " + id + " has been deleted";
	}
	
	
	
}
