package com.sathy.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sathy.mvc.data.BookEntity;
import com.sathy.mvc.data.BookModel;
import com.sathy.mvc.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookservice;
    @GetMapping("/books/getform")
    public String getProductForm(Model model) {
        BookModel book = new BookModel();
        book.setAuthor("Mr Rathan Sir");
        book.setCopies(100);

        model.addAttribute("book", book);
        model.addAttribute("genreDiscounts", getGenreDiscounts());
        model.addAttribute("genreTaxes", getGenreTaxes());

        return "add-book";
    }

    private Map<String, Double> getGenreDiscounts() {
        Map<String, Double> discounts = new HashMap<>();
        discounts.put("fiction", 5.0);
        discounts.put("science", 7.5);
        discounts.put("technology", 10.0);
        discounts.put("history", 12.5);
        return discounts;
    }

    private Map<String, Double> getGenreTaxes() {
        Map<String, Double> taxes = new HashMap<>();
        taxes.put("fiction", 2.0);
        taxes.put("science", 4.0);
        taxes.put("technology", 5.0);
        taxes.put("history", 7.0);
        return taxes;
    }


    @PostMapping("/books/save")
    public String saveBookData(@ModelAttribute BookModel bookmodel) {
        bookservice.saveBook(bookmodel); // ✅ Save to DB
        return "success";
    }

    @GetMapping("/books/getallbooks")
    public String getAllBooks(Model model) {
        List<BookEntity> bookList = bookservice.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "book-list"; // Thymeleaf file
    }

    @GetMapping("/books/search")
    public String searchBookById(@RequestParam Long id, Model model) {
        BookEntity book = bookservice.findBookById(id);
        model.addAttribute("book", book);
        return "search-result"; // ➕ This will render `search-result.html`
    }
   
    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookservice.deleteBookById(id);
        return "redirect:/books/getallbooks";
    }
    
    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        BookEntity book = bookservice.editBookById(id);
        model.addAttribute("book", book);  
        return "edit-book";  
    }
    
    @PostMapping("/books/edit")
    public String updateBook(@ModelAttribute BookEntity book) {
        bookservice.updateBook(book);
        return "redirect:/books/getallbooks";
    }

    
   

   


}
