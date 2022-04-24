package pl.oremczuk.bookcatalogueservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pl.oremczuk.bookcatalogueservice.models.from_other_microservices.Book;
import pl.oremczuk.bookcatalogueservice.models.BookCatalogue;
import pl.oremczuk.bookcatalogueservice.models.from_other_microservices.BookListWrapper;
import pl.oremczuk.bookcatalogueservice.models.from_other_microservices.BookPrice;
import pl.oremczuk.bookcatalogueservice.models.from_other_microservices.BookPriceListWrapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class BookCatalogueController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/{bookId}")
    public BookCatalogue getBookCatalogueItem(@PathVariable String bookId) {

        Book book = restTemplate.getForObject("http://localhost:8082/books/" + bookId, Book.class);
        BookPrice bookWithPrice = restTemplate.getForObject("http://localhost:8083/prices/" + bookId, BookPrice.class);

        return new BookCatalogue(bookId,book.getName(), book.getAuthor(), bookWithPrice.getPrice());

    }

    @GetMapping()
    public List<BookCatalogue> getBookCatalogueList() {

        BookListWrapper bookList = restTemplate.getForObject("http://localhost:8082/books/", BookListWrapper.class);

        return bookList.getBookList().stream()
                .map(book -> {
                    BookPrice bookWithPrice = restTemplate.getForObject("http://localhost:8083/prices/" + book.getBookId(), BookPrice.class);
                    return new BookCatalogue(book.getBookId(), book.getName(), book.getAuthor(), bookWithPrice.getPrice());
                    })
                .collect(Collectors.toList());

    }

    @GetMapping("/webflux")
    public List<BookCatalogue> getBookCatalogueListUsingWebflux() {

        BookPriceListWrapper bookWithPriceList = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/prices/")
                .retrieve()
                .bodyToMono(BookPriceListWrapper.class)
                .block();


        return bookWithPriceList.getPriceList().stream()
                .map(bookWithPrice -> {

                    Book book = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8082/books/" + bookWithPrice.getBookId())
                            .retrieve()
                            .bodyToMono(Book.class)
                            .block();

                    return new BookCatalogue(book.getBookId(), book.getName(), book.getAuthor(), bookWithPrice.getPrice());

                })
                .collect(Collectors.toList());

    }


}
