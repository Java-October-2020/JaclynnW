package com.jaclynn.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.dojosandninjas.models.Dojo;
import com.jaclynn.dojosandninjas.models.Ninja;
import com.jaclynn.dojosandninjas.repositories.DojoRepository;
import com.jaclynn.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	@Autowired
	private DojoRepository dRepo;
	@Autowired
	private NinjaRepository nRepo;
	
	//create
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	public Ninja createNinja(String firstName, String lastName, int age) {
		Ninja newNinja = new Ninja(firstName, lastName, age);
		return this.nRepo.save(newNinja);
		
	}
	public Dojo createDojo(String name) {
		Dojo newDojo = new Dojo(name);
		return this.dRepo.save(newDojo);
	}
	//get one
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	public Ninja getOneNinja(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	//Get all
	public List<Dojo> getAllDojos(){
		return this.dRepo.findAll();
	}
	public List<Ninja> getAllNinjas(){
		return this.nRepo.findAll();
	}
}
