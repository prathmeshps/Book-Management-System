package com.sathy.mvc.data;

import jakarta.persistence.*;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private double price;
    private int copies;
    private double discount;
    private double tax;
    private String createAt;
    private String createBy;

    // Constructors
    public BookEntity() {}

    public BookEntity(Long id, String title, String author, String genre, double price, int copies,
                      double dicount,double tax, String createAt, String createBy) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.copies = copies;
        this.createAt = createAt;
        this.createBy = createBy;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double dicount) {
        this.discount = discount;
    }
    
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

   
   

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
    	
    	
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "BookEntity [title=" + title + ", author=" + author + ", genre=" + genre + ", price=" + price
                + ", copies=" + copies + ", createAt=" + createAt + ", createBy="
                + createBy + "]";
    }
}
