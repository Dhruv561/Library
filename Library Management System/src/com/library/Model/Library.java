package com.library.Model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book name) {
        this.books.add(name);
    }

    public void addMembers(Member name) {
        this.members.add(name);
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return member;
            }
        }
        return null;
    }

    public boolean issueBook(int memberID, String isbn) {
        Member member = findMemberById(memberID);
        Book book = findBookByISBN(isbn);

        if (member instanceof Borrowable && book != null && book.isAvailable()) {
            Borrowable borrowableMember = (Borrowable) member;
            if (borrowableMember.borrow()) {
                book.setAvailable(false);
                return true;
            }
        }    
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);

        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("All Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getBookDetails());
            }
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("All Borrowed Books:");
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book.getBookDetails());
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}  
