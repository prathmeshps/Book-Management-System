package com.sathy.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathy.mvc.data.BookEntity;
import com.sathy.mvc.data.BookModel;
import com.sathy.mvc.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookrepository;

    // 🟡 Save book with calculated discount and tax
    public void saveBook(BookModel model) {
        BookEntity entity = new BookEntity();

        // Map model to entity
        entity.setTitle(model.getTitle());
        entity.setAuthor(model.getAuthor());
        entity.setGenre(model.getGenre());
        entity.setPrice(model.getPrice());
        entity.setCopies(model.getCopies());

        // Calculate discount and tax based on genre
        double discount = getDiscountByGenre(model.getGenre());
        double tax = getTaxByGenre(model.getGenre());

        entity.setDiscount(discount);
        entity.setTax(tax);

        // Default metadata
        entity.setCreateAt("2025-06-13");
        entity.setCreateBy("System");

        bookrepository.save(entity);
    }

    public List<BookEntity> getAllBooks() {
        return bookrepository.findAll();
    }

    public BookEntity findBookById(Long id) {
        return bookrepository.findById(id).orElse(null);
    }

    public void deleteBookById(long id) {
        bookrepository.deleteById(id);
    }

    public BookEntity editBookById(Long id) {
        return bookrepository.findById(id).orElse(null);
    }

    // 🟡 Update book with recalculated discount and tax
    public void updateBook(BookEntity updatedBook) {
        BookEntity existingBook = bookrepository.findById(updatedBook.getId()).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setCopies(updatedBook.getCopies());

            // Recalculate discount and tax
            double discount = getDiscountByGenre(updatedBook.getGenre());
            double tax = getTaxByGenre(updatedBook.getGenre());

            existingBook.setDiscount(discount);
            existingBook.setTax(tax);

            bookrepository.save(existingBook);
        }
    }

    // 🟩 Genre to Discount mapping
    private double getDiscountByGenre(String genre) {
        Map<String, Double> discountMap = new HashMap<>();
        discountMap.put("fiction", 5.0);
        discountMap.put("science", 7.5);
        discountMap.put("technology", 10.0);
        discountMap.put("history", 12.5);

        return discountMap.getOrDefault(genre.toLowerCase(), 0.0);
    }

    // 🟦 Genre to Tax mapping
    private double getTaxByGenre(String genre) {
        Map<String, Double> taxMap = new HashMap<>();
        taxMap.put("fiction", 2.0);
        taxMap.put("science", 4.0);
        taxMap.put("technology", 5.0);
        taxMap.put("history", 7.0);

        return taxMap.getOrDefault(genre.toLowerCase(), 0.0);
    }
}
