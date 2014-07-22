package com.kdubb.springdataelasticsearch.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdubb.springdataelasticsearch.domain.Book;
import com.kdubb.springdataelasticsearch.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Boolean create(@RequestBody Book book) {
		book.setId(UUID.randomUUID().toString());
		bookRepository.save(book);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Iterable<Book> find() {
		return bookRepository.findAll();
	}
}