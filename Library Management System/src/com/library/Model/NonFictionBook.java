package com.library.Model;

public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(String title, String author, String isbn, int year, String subject) {
        super(title, author, isbn, year);
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getBookDetails() {
        return "Tite: " + getTitle() +
               "\nAuthor: " + getAuthor() +
               "\nISBN: " + getISBN() +
               "\nPublication Year: " + getPublicationYear() +
               "\nSubject: " + subject + 
               "\nIs Available: " + isAvailable();
    }

    @Override
    public String toString() {
        return super.toString() + "\nSubject: " + subject;
    }
}
