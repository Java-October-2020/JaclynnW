package com.jaclynn.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.relationships.models.Person;
import com.jaclynn.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	
	
	//Get All
	public List<Person> getAllPersons(){
		return this.pRepo.findAll();
	}
	//Get One
	public Person getOnePerson(Long id){
		return this.pRepo.findById(id).orElse(null);
	}
	//get unlicensed
	public List<Person> getUnlicensedPerson(){
		return this.pRepo.findByLicenseIdIsNull();
	}
	
	//Create a Person
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	public Person createPerson(String firstName, String lastName) {
		Person newPerson = new Person(firstName, lastName);
		return this.pRepo.save(newPerson);
	}
	//Update Person
	public Person updatePerson(Person updatedPerson) {
		return this.pRepo.save(updatedPerson);
	}
	//Delete Person
	public void killPerson(Long id) {
		this.pRepo.deleteById(id);
	}

}
