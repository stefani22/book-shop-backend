package mk.ukim.finki.book_shop_backend.model.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {

        super("Country with id %d does not exits.".formatted(id));
    }
}
