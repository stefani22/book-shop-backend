package mk.ukim.finki.book_shop_backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.book_shop_backend.model.domain.Country;

public record CreateCountryDto(
        @NotBlank(message = "The name of the country is required")
        String name,
        @NotBlank(message = "Continent is required")
        String continent
) {

    public Country toCountry(){
        return new Country(continent, name);
    }
}
