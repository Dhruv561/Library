package com.library.Model;

public abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean available;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = year;
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    
    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(int year) {
        this.publicationYear = year;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String getBookDetails();

    @Override
    public String toString() {
        return "Title: " + this.title + 
               "\nAuthor: " + this.author + 
               "\nISBN: " + this.isbn + 
               "\nPublication Year: " + this.publicationYear + 
               "\nIs Available: " + this.available;
    }
}
