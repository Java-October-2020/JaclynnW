package com.jaclynn.beltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@Future
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date date;
	
	@NotBlank
	private String location;
	@Size(max=2)
	@NotBlank
	private String state;
	
	//one event will have many comments
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	//many events will be created by one user
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User planner;
	
	//many events will be attended by many users
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="guestlist",
			joinColumns = @JoinColumn(name="event_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> guests;
	
	
	
	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public List<User> getGuests() {
		return guests;
	}


	public void setGuests(List<User> guests) {
		this.guests = guests;
	}


	public Event() {
		super();
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public User getPlanner() {
		return planner;
	}


	public void setPlanner(User planner) {
		this.planner = planner;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	

}
