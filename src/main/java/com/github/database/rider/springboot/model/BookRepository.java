package com.github.database.rider.springboot.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByIsbn(String isbn);

}
