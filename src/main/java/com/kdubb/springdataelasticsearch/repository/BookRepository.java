package com.kdubb.springdataelasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.kdubb.springdataelasticsearch.domain.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

	Page<Book> findByNameAndPrice(String name, Integer price, Pageable pageable);
	
   Page<Book> findByNameOrPrice(String name, Integer price, Pageable pageable);
   
   Page<Book> findByName(String name, Pageable pageable);
}