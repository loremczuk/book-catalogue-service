package pl.oremczuk.bookcatalogueservice.models.from_other_microservices;

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
