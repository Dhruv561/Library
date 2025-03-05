package com.library.UI;

import com.library.Model.*;
import java.util.Scanner;

public class App {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        displayMenu();
    }

    private static void displayMenu() {
        System.out.println("\t\tLibrary Management System\n");
        int choice;
        do {
            System.out.println(" 1. Add Book\n 2. Add Member\n 3. Issue Book\n 4. Return Book\n 5. View Available Books\n 6. View Borrowed Books\n 7. Exit");
            System.out.println(">>> ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1: 
                addBook();
                break;

                case 2:
                addMember();
                break;

                case 3:
                issueBook();
                break;

                case 4:
                returnBook();
                break;

                case 5:
                library.displayAvailableBooks();
                break;

                case 6:
                library.displayBorrowedBooks();
                break;

                case 7:
                System.out.println("Exiting program");
                break;

                default:
                System.out.println("Invalid input");
                break;
            }
        } while (choice != 7);
        scanner.close();
    }

    private static void init() {
        FictionBook fb1 = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227", 1954, "Fantasy");
        NonFictionBook nfb1 = new NonFictionBook("Sapiens", "Yuval Noah Harari", "978-0062464701", 2015, "History");
        library.addBook(fb1);
        library.addBook(nfb1);
        StudentMember sm1 = new StudentMember(123, "Alice");
        FacultyMember fm1 = new FacultyMember(456, "Bob");
        library.addMembers(sm1);
        library.addMembers(fm1);
    }

    private static void addBook() {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter isbn: ");
        String isbn = scanner.nextLine();
        System.out.println("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type of book: \n 1. Fiction\n 2. Non Fiction");
        int bookType = scanner.nextInt();
        scanner.nextLine();
        if (bookType == 1) {
            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();
            library.addBook(new FictionBook(title, author, isbn, year, genre));
        } else if (bookType == 2) {
            System.out.println("Enter subject: ");
            String subject = scanner.nextLine();
            library.addBook(new NonFictionBook(title, author, isbn, year, subject));
        }
        System.out.println("Book added");
    }

    private static void addMember() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Member type: \n 1. Student\n 2. Teacher");
        int option = scanner.nextInt();
        if (option == 1) {
            library.addMembers(new StudentMember(id, name));
        } else if (option == 2) {
            library.addMembers(new FacultyMember(id, name));
        }
        System.out.println("Member added");
    }

    private static void issueBook() {
        System.out.println("Enter member id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter isbn: ");
        String isbn = scanner.nextLine();
        if (library.issueBook(id, isbn)) {
            System.out.println("Book issued successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    private static void returnBook() {
        System.out.println("Enter isbn: ");
        String isbn = scanner.nextLine();
        if (library.returnBook(isbn)) {
            System.out.println("Book returned");
        } else {
            System.out.println("Error in returning book");
        }
    }
}
