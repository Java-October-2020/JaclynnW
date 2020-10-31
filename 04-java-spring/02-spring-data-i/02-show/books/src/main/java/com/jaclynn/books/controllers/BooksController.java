package com.jaclynn.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaclynn.books.models.Book;
import com.jaclynn.books.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
	List<Book> books = bookService.allBooks();
	model.addAttribute("books", books);
	return "index.jsp";
	}
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") Long index) {
		Book book = bookService.findBook(index);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()){
			return "new.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	

}
