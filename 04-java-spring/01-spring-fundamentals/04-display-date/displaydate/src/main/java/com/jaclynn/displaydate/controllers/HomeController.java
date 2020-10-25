package com.jaclynn.displaydate.controllers;




import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.util.calendar.BaseCalendar.Date;

@Controller
public class HomeController {	
	@RequestMapping("/{dateTime}")
	public String DateTime(@PathVariable("dateTime") String dateTime, Model model) {
		if(dateTime.equals("date")) {
			SimpleDateFormat pDate = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
			model.addAttribute("dateTime", pDate.format(new java.util.Date()));
			return "date.jsp";
		}
		else if(dateTime.equals("time")) {
			SimpleDateFormat pTime = new SimpleDateFormat("h:mm a");
			model.addAttribute("time", pTime);
			return "time.jsp";			
		}
		return "redirect:/";
	}


}
