package com.sathy.mvc.data;

public class BookModel {

    private String title;
    private String author;
    private String genre;
    private double price;
    private int copies;
    private double discount;
    private double tax;


    // Constructors
    public BookModel() {}

    public BookModel(String title, String author, String genre, double price, int copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.copies = copies;
    }

    // Getters and Setters
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
}
