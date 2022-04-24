package pl.oremczuk.bookcatalogueservice.models.from_other_microservices;

import java.util.List;

public class BookPriceListWrapper {

    private List<BookPrice> priceList;

    public BookPriceListWrapper() {
    }

    public BookPriceListWrapper(List<BookPrice> priceList) {
        this.priceList = priceList;
    }

    public List<BookPrice> getPriceList() {
        return priceList;
    }
}
