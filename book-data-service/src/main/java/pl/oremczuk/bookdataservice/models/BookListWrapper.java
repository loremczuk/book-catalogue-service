package pl.oremczuk.bookdataservice.models;

import java.util.List;

public class BookListWrapper {

    private List<Book> bookList;

    public BookListWrapper(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
