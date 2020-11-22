package com.jaclynn.beltreviewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.beltreviewer.models.Comment;
import com.jaclynn.beltreviewer.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cRepo;
	
	//create a message
	public Comment createComment(Comment comment) {
		return this.cRepo.save(comment);
	}

}
