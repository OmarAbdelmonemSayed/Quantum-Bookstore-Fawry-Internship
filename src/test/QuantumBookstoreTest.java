package src.test;

import src.books.*;
import src.store.*;

import java.util.List;

public class QuantumBookstoreTest {
    public static void main(String[] args) {
        System.out.println("*** Quantum book store ***");

        BookStore store = new BookStore();

        // Add books
        store.addBook(new PaperBook("111", "Java Basics", "John Doe", 2018, 150.0, 5));
        store.addBook(new EBook("222", "Learn Python", "Alice Smith", 2020, 100.0, "PDF"));
        store.addBook(new DemoBook("333", "C++ Preview", "Mark Lee", 2010, 0.0));

        System.out.println("Quantum book store: Added 3 src.books.");

        // Try to buy a PaperBook (valid)
        double amount1 = store.buyBook("111", 2, "test@mail.com", "123 Street");
        System.out.println("Quantum book store: Paid amount = " + amount1);

        // Try to buy an EBook
        double amount2 = store.buyBook("222", 1, "user@mail.com", "");
        System.out.println("Quantum book store: Paid amount = " + amount2);

        // Try to buy a DemoBook (should fail)
        try {
            store.buyBook("333", 1, "x@mail.com", "no address");
        } catch (Exception e) {
            System.out.println("Quantum book store: Failed to buy demo book -> " + e.getMessage());
        }

        // Try to overbuy PaperBook (should fail)
        try {
            store.buyBook("111", 10, "x@mail.com", "address");
        } catch (Exception e) {
            System.out.println("Quantum book store: Overbuy failed -> " + e.getMessage());
        }

        // Remove outdated books (older than 5 years)
        List<Book> outdated = store.removeOutdatedBooks(2025, 5);
        System.out.println("Quantum book store: Removed " + outdated.size() + " outdated book(s).");

        System.out.println("Quantum book store: All tests done.");
    }
}
