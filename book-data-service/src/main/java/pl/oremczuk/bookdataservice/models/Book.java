package pl.oremczuk.bookdataservice.models;

public class Book {

    String bookId;
    String name;
    String author;

    public Book() {
    }

    public Book(String bookId, String name, String author) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
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

}
