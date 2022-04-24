package pl.oremczuk.bookcatalogueservice.models.from_other_microservices;

import pl.oremczuk.bookcatalogueservice.models.from_other_microservices.Book;

import java.util.List;

public class BookListWrapper {

    private List<Book> bookList;

    public BookListWrapper() {
    }

    public BookListWrapper(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
