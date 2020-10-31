package com.jaclynn.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jaclynn.books.models.Book;
import com.jaclynn.books.repositories.BookRepository;

@Service
public class BookService {
	

		//adding the book repository as a dependency
		private final BookRepository bookRepository;
		
		public BookService(BookRepository bookRepository) {
			this.bookRepository = bookRepository;
		}
		
		// returns all the books
		public List<Book> allBooks(){
			return bookRepository.findAll();
		}

		// creates a book
		public Book createBook(Book b) {
			return bookRepository.save(b);
		}
		// retrieves a book
		public Book findBook(Long id) {
			Optional<Book> optionalBook = bookRepository.findById((long) id);
			if(optionalBook.isPresent()) {
				return optionalBook.get();
			}
			else {
				return null;
			}
		}


		}
	


