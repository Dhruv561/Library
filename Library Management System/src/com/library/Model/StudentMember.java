package com.library.Model;

public class StudentMember extends Member implements Borrowable{
    private int booksBorrowed;
    
    public StudentMember(int memberId, String name) {
        super(memberId, name);
        this.booksBorrowed = 0;
    }

    public int getBooksBorrowed() {
        return this.booksBorrowed;
    }

    public void setBooksBorrowed(int booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    @Override
    public int getMaxBorrowingDays() {
        return 30;
    }

    @Override
    public boolean borrow() {
        if (booksBorrowed <= 3) {
            booksBorrowed++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean returnItem() {
        if (booksBorrowed > 0) {
            booksBorrowed--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nBooks Borrowed: " + this.booksBorrowed;
    }
}
