package com.shop.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
