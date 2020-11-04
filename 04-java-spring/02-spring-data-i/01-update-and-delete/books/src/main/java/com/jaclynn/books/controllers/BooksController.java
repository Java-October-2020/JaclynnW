package com.jaclynn.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaclynn.books.models.Book;
import com.jaclynn.books.services.BookService;


@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
	List<Book> books = bookService.allBooks();
	model.addAttribute("books", books);
	return "index.jsp";
	}
	@RequestMapping("/{id}")
	public String findBookByIndex(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	@RequestMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	@PostMapping("/")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()){
			return "new.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/";
		}
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("book") Book updatedBook) {
		viewModel.addAttribute("book", this.bookService.findBook(id));
		return "editBook.jsp";
	}
		
	@PutMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		if (book != null) {
			return "editBook.jsp";
			}
		else {
			return "redirect:/";
		}
	}
	@PostMapping("/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book updatedBook, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookService.updateBook(updatedBook);
			return "redirect:/";
		}
	}
	@GetMapping("/delete/{id}")
	public String destroyBook(@PathVariable("id") Long id) {
		this.bookService.destroyBook(id);
		return "redirect:/";
	}
}
