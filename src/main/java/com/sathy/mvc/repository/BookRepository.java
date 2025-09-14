package com.sathy.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sathy.mvc.data.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
