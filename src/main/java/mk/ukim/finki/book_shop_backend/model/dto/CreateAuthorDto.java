package mk.ukim.finki.book_shop_backend.model.dto;
import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.book_shop_backend.model.domain.Author;
import mk.ukim.finki.book_shop_backend.model.domain.Country;

public record
CreateAuthorDto(
        @NotBlank(message = "A name is required.")
        String name,
        @NotBlank(message = "A surname is required.")
        String surname,
        Long countryId
) {

    public Author toAuthor(Country country){
        return new Author(country, name, surname);
    }
}
