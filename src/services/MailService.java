package src.services;

import src.books.Book;

public class MailService {
    public static void send(Book book, String email) {
        // sending the book to the client by email
        System.out.println("Sending " + book.getTitle() + " Book to " + email);
    }
}
