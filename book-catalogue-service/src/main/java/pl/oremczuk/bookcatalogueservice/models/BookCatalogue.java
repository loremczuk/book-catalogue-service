package pl.oremczuk.bookcatalogueservice.models;

public class BookCatalogue {

    String bookId;
    String name;
    String author;
    String price;

    public BookCatalogue() {
    }

    public BookCatalogue(String bookId, String name, String author, String price) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }
}
