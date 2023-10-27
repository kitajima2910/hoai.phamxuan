package com.gameloft.mkyong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gameloft.mkyong.model.Book;
import java.time.LocalDate;


//Spring Data JPA creates CRUD implementation at runtime automatically.
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
	
	// Custom query
	@Query("select b from Book b where b.publishDate > :date")
	List<Book> findByPublishedDateAfter(@Param("date") LocalDate date);
	
}
