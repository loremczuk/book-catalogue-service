package pl.oremczuk.bookpricingservice.models;

public class BookPrice {

    String bookId;
    String price;

    public BookPrice() {
    }

    public BookPrice(String bookId, String price) {
        this.bookId = bookId;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getPrice() {
        return price;
    }

}
