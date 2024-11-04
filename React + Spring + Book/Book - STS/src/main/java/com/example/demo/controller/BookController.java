package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.expection.ResourceNotFoundException;
import com.example.demo.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/{id}")
	public Book getByBook(@PathVariable Long id) {
		return bookRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
		book.setTitle(bookDetails.getTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setDescription(bookDetails.getDescription());
		book.setImageUrl(bookDetails.getImageUrl());
		final Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteBook(@PathVariable Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
		bookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}