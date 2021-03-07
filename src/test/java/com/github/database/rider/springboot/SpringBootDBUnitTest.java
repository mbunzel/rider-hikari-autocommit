package com.github.database.rider.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.github.database.rider.springboot.model.BookRepository;

/**
 * Created by pestano on 13/09/16.
 */
@DBRider
@SpringBootTest
public class SpringBootDBUnitTest {

	@Autowired
	private BookRepository bookRepository;

	@AfterAll
	@DataSet("emptyBooks.yml")
	public static void cleanUp() {
	}

	@BeforeEach
	@DataSet("books.yml")
	public void setUpBooks() {
	}

	@Test
	public void shouldListBooks() {
		assertThat(bookRepository).isNotNull();
		assertThat(bookRepository.count()).isEqualTo(3);
	}
}
