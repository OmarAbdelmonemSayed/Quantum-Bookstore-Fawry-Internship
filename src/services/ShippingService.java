package src.services;

import src.books.Book;

public class ShippingService {
    public static void shipping(Book book, String address) {
        // shipping the book to the client
        System.out.println("Shipping " + book.getTitle() + " Book at " + address);
    }
}
