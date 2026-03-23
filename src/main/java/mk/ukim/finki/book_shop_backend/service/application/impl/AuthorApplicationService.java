package mk.ukim.finki.book_shop_backend.service.application.impl;

import mk.ukim.finki.book_shop_backend.model.domain.Country;
import mk.ukim.finki.book_shop_backend.model.dto.CreateAuthorDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayAuthorDto;
import mk.ukim.finki.book_shop_backend.model.exception.CountryNotFoundException;
import mk.ukim.finki.book_shop_backend.service.domain.AuthorService;
import mk.ukim.finki.book_shop_backend.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationService implements mk.ukim.finki.book_shop_backend.service.application.AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationService(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());
    }

    @Override
    public DisplayAuthorDto create(CreateAuthorDto createAuthorDto) {
        Country country = countryService.findById(createAuthorDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createAuthorDto.countryId()));
        return DisplayAuthorDto.from(authorService.create(createAuthorDto.toAuthor(country)));
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        Country country = countryService.findById(createAuthorDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createAuthorDto.countryId()));
        return authorService.update(id, createAuthorDto.toAuthor(country)).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> deleteById(Long id) {
        return authorService.deleteById(id).map(DisplayAuthorDto::from);
    }
}
