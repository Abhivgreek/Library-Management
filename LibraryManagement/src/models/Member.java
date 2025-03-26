package models;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Member {
    private String name;
    private int memberID;
    private List<Book> borrowedBooks;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void printBorrowedBooks() {
        ListIterator<Book> iterator = borrowedBooks.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return name + " (ID: " + memberID + ")";
    }
}