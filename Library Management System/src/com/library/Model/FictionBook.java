package com.library.Model;

public class FictionBook extends Book{
    private String genre;

    public FictionBook(String title, String author, String isbn, int year, String genre) {
        super(title, author, isbn, year);
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getBookDetails() {
        return "Tite: " + getTitle() +
               "\nAuthor: " + getAuthor() +
               "\nISBN: " + getISBN() +
               "\nPublication Year: " + getPublicationYear() +
               "\nGenre: " + genre + 
               "\nIs Available: " + isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre;
    }
}
