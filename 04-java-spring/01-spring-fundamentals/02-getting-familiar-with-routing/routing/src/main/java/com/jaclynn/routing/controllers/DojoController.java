package com.jaclynn.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DojoController {
	
	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		dojo = "dojo";
		return "The dojo is awesome!";
	}
	@RequestMapping("/dojo/{location}")
	public String dojoLocation(@PathVariable String location) {
		switch(location) {
		case "burbank":
			return "Burbank Dojo is located in Southern California";
		case "san-jose":
			return "SJ dojo is the headquarters";
		default:
			return location + "is probably super cool";
		}
//		String message = "";
//			if(location == "burbank" ) {
//			System.out.println("Burbank");
//			message = "Burbank Dojo is located in Southern California";
//			}
//			else if(location == "san-jose") {
//				System.out.println("SanJose");
//			message = "SJ dojo is the headquarters.";
//			}
//			return message;
		}
	

}
