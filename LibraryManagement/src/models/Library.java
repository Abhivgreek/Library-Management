package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<String, Book> books;
    private Set<Member> members;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashSet<>();
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayBooks() {
        Iterator<Book> iterator = books.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Book searchBook(String ISBN) {
        return books.get(ISBN);
    }

    public int getTotalMembers() {
        return members.size();
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getCurrentlyBorrowedBooks() {
        int count = 0;
        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // Add this method to get the list of members
    public Set<Member> getMembers() {
        return members;
    }
}