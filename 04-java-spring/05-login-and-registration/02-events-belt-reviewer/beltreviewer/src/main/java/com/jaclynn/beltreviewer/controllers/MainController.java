package com.jaclynn.beltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaclynn.beltreviewer.models.Comment;
import com.jaclynn.beltreviewer.models.Event;
import com.jaclynn.beltreviewer.models.User;
import com.jaclynn.beltreviewer.services.CommentService;
import com.jaclynn.beltreviewer.services.EventService;
import com.jaclynn.beltreviewer.services.UserService;

@Controller
@RequestMapping("/events")
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;
	@Autowired
	private CommentService cService;
	
	//method to get user ID from session and 
	
	@GetMapping("")
	public String index(@ModelAttribute("event") Event event, Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		List<Event> events = this.eService.getAllEvents();
		viewModel.addAttribute("allEvents", events);
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("usersStates", this.eService.allEventsWithState(user.getState()));
		viewModel.addAttribute("otherStates", this.eService.allEventsNotState(user.getState()));
		
		return "dashboard.jsp";
				
	}
	@PostMapping("/new")
	public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "dashboard.jsp";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		event.setPlanner(user);
		eService.createEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/rsvp/{id}")
	public String rsvp(@PathVariable("id") Long id, @ModelAttribute("event") Event event, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long eventId = id;
		User guest = this.uService.findOneUser(userId);
		Event attendedEvent = this.eService.getOneEvent(eventId);
		this.eService.addAttendee(guest, attendedEvent);
		return "redirect:/events";
	}
	
	@GetMapping("/unrsvp/{id}")
	public String unrsvp(@PathVariable("id") Long id,@ModelAttribute("event") Event event, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long eventId = id;
		User guest = this.uService.findOneUser(userId);
		Event attendedEvent = this.eService.getOneEvent(eventId);
		this.eService.cancelAttendance(guest, attendedEvent);;
		return "redirect:/events";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long eventId = id;
		Event deletedEvent = this.eService.getOneEvent(eventId);
		this.eService.deleteEvent(deletedEvent);
		return "redirect:/events";
	}
	
	@GetMapping("/edit/{id}")
	public String editEvent(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Event currentEvent = this.eService.getOneEvent(id);
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("event", currentEvent);
		viewModel.addAttribute("user_id", userId);
		return "editevent.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String changeEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			Event currentEvent = this.eService.getOneEvent(id);
			viewModel.addAttribute("event", currentEvent);
			viewModel.addAttribute("user_id", userId);
			return "editevent.jsp";
		}
		this.eService.updateEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/{id}")
	public String displayEvent(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long eventId = id;
		Event currentEvent = this.eService.getOneEvent(eventId);
		viewModel.addAttribute("event", currentEvent);
		return "showevent.jsp";
	}
	
	@PostMapping("/comment/{id}")
	public String addComment(@PathVariable("id") Long id, @RequestParam("message") String comment, RedirectAttributes redrattr, HttpSession session) {

		if(comment.equals("")) {
			redrattr.addFlashAttribute("error", "Comment must not be blank");
			return "redirect:/events"+ id;
			
		}
		Long userId = (Long)session.getAttribute("user_id");
		Event event = this.eService.getOneEvent(id);
		User user = this.uService.findOneUser(userId);
		Comment newComment = new Comment();
		newComment.setMessage(comment);
		newComment.setAuthor(user);
		newComment.setEvent(event);
		this.cService.createComment(newComment);
		return "redirect:/events/" + id;
	}
	
	

}
