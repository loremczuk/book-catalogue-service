package pl.oremczuk.bookdataservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.oremczuk.bookdataservice.models.Book;
import pl.oremczuk.bookdataservice.models.BookListWrapper;

import java.util.Arrays;


@RestController
@RequestMapping("/books")
public class BookDataController {

    @GetMapping()
    public BookListWrapper getBookList() {
        return new BookListWrapper(Arrays.asList(
                new Book("2", "Pan Tadeusz", "Adam Mickiewicz"),
                new Book("3", "Ludzie bezdomni", "Stefan Żeromski")
        ));
    }


    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable String bookId) {

        return new Book(bookId, "W pustyni i w puszczy", "Henryk Sienkiewicz");
    }

}
