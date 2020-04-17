package com.sap.devcamp.stepat.bookshop.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sap.devcamp.stepat.bookshop.model.Book;
import com.sap.devcamp.stepat.bookshop.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void createBook(final Book book) {
		if (bookRepository.existsBookByIsbn(book.getIsbn())) {
			bookRepository.save(book);
		} else {
			throw new EntityExistsException("Could not save Book entity with ISBN " + book.getIsbn() + " . An entity with that ISBN already exists.")
;		}
		
	}
	
	public List<Book> getAll() {
		return bookRepository.getAll();
	}
	
	public List<Book> getAllBooksFromAuthor(String author) {
		return bookRepository.getAllBooksFromAuthor(author);
	}
	
	public void deleteBook(UUID uuid) {
		bookRepository.deleteBookByUuid(uuid);
	}
	
	public Book findBookByTitle(String title) {
		return bookRepository.findBookByTitle(title);
	}
	
	public void updateBook(final Book book) {
		if (bookRepository.existsBookByIsbn(book.getIsbn())) {
			bookRepository.save(book);
			return bookRepository.findBookByIsbn(book.getIsbn());
	}
		throw new EntityNotFoundException("Could not update Book entity because it does not exist. " + book.getIsbn());
		}
	
	
	
	
}
