package com.jaclynn.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaclynn.lookify.models.Song;
import com.jaclynn.lookify.services.LookifyService;


@Controller
public class SongController {
	@Autowired
	private LookifyService lService;
	
	@GetMapping("")
	public String home() {
		return "lookify.jsp";
		
	}
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		List<Song> songs = this.lService.getAllSongs();
		viewModel.addAttribute("allSongs", songs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String addForm(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	
	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song newSong, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		else {
			this.lService.createSong(newSong);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/{id}")
	public String showSong(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("song") Song song) {
		viewModel.addAttribute("song", this.lService.getOneSong(id));
		return "songs.jsp";
	}
	
	@GetMapping("/songs/search")
	public String searchByArtist(@RequestParam("artist") String artist, Model viewModel) {
		viewModel.addAttribute("songs", lService.getAllByArtist(artist));
		viewModel.addAttribute("artist", artist);
		return "searched.jsp";
	}
	@GetMapping("/search/topTen")
	public String searchTop10(Model viewModel) {
		viewModel.addAttribute("songs", lService.topTenByRating());
		return "topten.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.lService.deleteSong(id);
		return "redirect:/dashboard";
	}

}
