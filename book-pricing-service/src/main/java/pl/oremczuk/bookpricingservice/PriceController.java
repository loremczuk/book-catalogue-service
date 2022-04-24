package pl.oremczuk.bookpricingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.oremczuk.bookpricingservice.models.BookPrice;
import pl.oremczuk.bookpricingservice.models.BookPriceListWrapper;
import java.util.Arrays;


@RestController
@RequestMapping("/prices")
public class PriceController {

    @GetMapping()
    public BookPriceListWrapper getPriceList() {
        return new BookPriceListWrapper(Arrays.asList(
                new BookPrice("2", "$15.00"),
                new BookPrice("3", "$20.00")));
    }

    @GetMapping("/{bookId}")
    public BookPrice getBookPrice(@PathVariable String bookId) {
        return new BookPrice(bookId, "$10.00");
    }
}
