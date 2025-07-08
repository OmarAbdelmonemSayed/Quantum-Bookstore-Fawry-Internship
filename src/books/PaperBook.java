package src.books;

import src.books.interfaces.Buyable;
import src.services.ShippingService;

public class PaperBook extends Book implements Buyable {
    private int stock;

    public PaperBook() {}

    public PaperBook(String ISBN, String title, String author, int publicationYear, double price, int stock) {
        super(ISBN, title, author, publicationYear, price);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity > this.stock) {
            throw new RuntimeException("Requested quantity exceeds available stock.");
        }
        this.stock -= quantity;
        ShippingService.shipping(this, address);
        return this.price * quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
