package com.jaclynn.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.lookify.models.Song;
import com.jaclynn.lookify.repositories.LookifyRepository;

@Service
public class LookifyService  {
	@Autowired
	private LookifyRepository lRepo;
	
	//Get all
	public List<Song> getAllSongs(){
		return this.lRepo.findAll();
	}
	// Get by Artist Search
	public List<Song> getAllByArtist(String search) {
		return this.lRepo.findByArtistContaining(search);
	}
	
	// Get One
	public Song getOneSong(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	// Create Song
	public Song createSong(Song newSong) {
		return this.lRepo.save(newSong);
	}
	public Song createSong(String title, String artist, int rating) {
		Song newSong = new Song(title, artist, rating);
		return this.lRepo.save(newSong);
	}
	//Update a song
	public Song updateSong(Song updatedSong) {
		return this.lRepo.save(updatedSong);
	}
	//Delete a song
	public void deleteSong(Long id) {
		this.lRepo.deleteById(id);
	}
	//find top 10
	public List<Song> topTenByRating(){
		return lRepo.findTop10ByOrderByRatingDesc();
	}




}
