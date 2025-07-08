package store;

import books.Book;
import books.interfaces.Buyable;

import java.util.*;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();

    public BookStore() {}

    public BookStore(Map<String, Book> books) {
        this.inventory = books;
    }

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
    }

    public List<Book> removeOutdatedBooks(int currentYear, int thresholdYears) {
        List<Book> outdatedBooks = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getPublicationYear() > thresholdYears) {
                outdatedBooks.add(book);
                iterator.remove();
            }
        }

        return outdatedBooks;
    }

    public void removeBook(String ISBN) {
        inventory.remove(ISBN);
    }

    public Book getBook(String ISBN) {
        return inventory.get(ISBN);
    }

    public Map<String, Book> getBooks() {
        return inventory;
    }

    public void setBooks(Map<String, Book> books) {
        this.inventory = books;
    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        double total = 0;
        Book book = getBook(ISBN);

        if (!(book instanceof Buyable)) {
            throw new RuntimeException("Can't buy a non buy-able Book");
        }

        total += ((Buyable)book).buy(quantity, email, address);

        return total;
    }
}
