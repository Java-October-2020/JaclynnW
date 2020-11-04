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
		
		 private List<Book> books = new ArrayList<Book>(Arrays.asList());
		 
		 
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
		//updates a book
		public Book updateBook(Book book) {
			return this.bookRepository.save(book);

		}
		public List<Book> updateBook(Long id) {
			return this.bookRepository.save(id);
			
		}
		/*
		 * public void updateBook(Long id, String description, String language, int
		 * numOfPages) { this.bookRepository.save(id);
		 */
			
			/*
			 * public Record updateRecord(Record updatedRecord) { return
			 * this.rRepo.save(updatedRecord);
			 */
		
			/* } */
		// deletes a book
		public void destroyBook(Long id) {
			this.bookRepository.deleteById(id);
		}
		// Delete Record
//		public String deleteRecord(Long id) { //can be void but string is just confirming we did something
//			this.rRepo.deleteById(id);
//			return "Record " + id + " has been deleted";
//		}

		public void updateBook(Long id, String desc, String lang, Integer numOfPages) {
			// TODO Auto-generated method stub
			
		}

}



	


