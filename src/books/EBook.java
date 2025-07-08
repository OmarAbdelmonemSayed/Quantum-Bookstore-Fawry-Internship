package src.books;

import src.books.interfaces.Buyable;
import src.services.MailService;

public class EBook extends Book implements Buyable {
    private String fileType;

    public EBook() {}

    public EBook(String ISBN, String title, String author, int publicationYear, double price, String fileType) {
        super(ISBN, title, author, publicationYear, price);
        this.fileType = fileType;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        MailService.send(this, email);
        return this.price * quantity;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
