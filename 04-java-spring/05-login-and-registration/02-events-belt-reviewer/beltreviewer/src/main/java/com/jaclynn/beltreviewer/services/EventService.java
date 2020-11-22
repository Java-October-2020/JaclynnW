package com.jaclynn.beltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.beltreviewer.models.Event;
import com.jaclynn.beltreviewer.models.User;
import com.jaclynn.beltreviewer.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	//find one event
	public Event getOneEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	//get all events
	public List<Event> getAllEvents(){
		return this.eRepo.findAll();
	}
	//get all events by state
	public List<Event> allEventsWithState(String state){
		return this.eRepo.findByState(state);
	}
	//get all events where a state is not a particular state
	public List <Event> allEventsNotState(String state){
		return this.eRepo.findByStateIsNot(state);
	}
	
	//create an event
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	//update an event
	public Event updateEvent(Event event) {
		return this.eRepo.save(event);
	
	}
	//Attend an event
	public void addAttendee(User user, Event event) {
		List<User> attendees = event.getGuests();
		//add a user to the guest list
		attendees.add(user);
		//save the event
		this.eRepo.save(event);
	}

	//cancel attending an event
	public void cancelAttendance(User user, Event event) {
		List <User> attendees = event.getGuests();
		attendees.remove(user);
		this.eRepo.save(event);
	}
	
	//delete event
	public void deleteEvent(Event event) {
		this.eRepo.delete(event);
	}
}
