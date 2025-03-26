package services;

import exceptions.BookAlreadyBorrowedException;
import exceptions.BookNotAvailableException;
import exceptions.MemberNotFoundException;
import models.Book;
import models.Library;
import models.Member;

public class LibraryService {
    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public void borrowBook(int memberID, String ISBN) throws MemberNotFoundException, BookNotAvailableException, BookAlreadyBorrowedException {
        Member member = findMemberById(memberID);
        Book book = library.searchBook(ISBN);

        if (book == null) {
            throw new BookNotAvailableException("Book is not available.");
        }

        if (!book.isAvailable()) {
            throw new BookAlreadyBorrowedException("You have already borrowed this book.");
        }

        member.borrowBook(book);
        book.setAvailable(false);
    }

    public void returnBook(int memberID, String ISBN) throws MemberNotFoundException, BookNotAvailableException {
        Member member = findMemberById(memberID);
        Book book = library.searchBook(ISBN);

        if (book == null) {
            throw new BookNotAvailableException("You did not borrow this book.");
        }

        member.returnBook(book);
        book.setAvailable(true);
    }

    // Change this method to public
    public Member findMemberById(int memberID) throws MemberNotFoundException {
        for (Member member : library.getMembers()) {
            if (member.getMemberID() == memberID) {
                return member;
            }
        }
        throw new MemberNotFoundException("Member not found.");
    }

    public void printStatistics() {
        System.out.println("Total Members: " + library.getTotalMembers());
        System.out.println("Total Books: " + library.getTotalBooks());
        System.out.println("Currently Borrowed Books: " + library.getCurrentlyBorrowedBooks());
    }
}