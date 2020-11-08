package com.jaclynn.relationships.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.relationships.models.License;
import com.jaclynn.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;

	
	//Get All
	public List<License> getAllLicenses(){
		return this.lRepo.findAll();
	}
	//Get One
	public License getOneLicense(Long id){
		return this.lRepo.findById(id).orElse(null);
	}
	
	
	//Create a License
	public License createLicense(License newLicense) {
		newLicense.setNumber(this.createLicenseNumber());
		return this.lRepo.save(newLicense);
	}
	public License createLicense(String number, Date expiration_date, String state) {
		License newLicense = new License(number, expiration_date, state);
		return this.lRepo.save(newLicense);
	}
	//Update License
	public License updateLicense(License updatedLicense) {
		return this.lRepo.save(updatedLicense);
	}
	//Delete License
	public void deleteLicense(Long id) {
		this.lRepo.deleteById(id);
	}
	
	//Generate a license number
	public String createLicenseNumber() {
		License lastLicense = lRepo.findTopByOrderByNumberDesc();
		if(lastLicense == null) {
			return "0000001";
		}
		else {
		int lastLicenseNumber = Integer.parseInt(lastLicense.getNumber());
		lastLicenseNumber++;
		String newLicenseNumber = String.format("%07d", lastLicenseNumber);
		return newLicenseNumber;
		}
		
	}
}
