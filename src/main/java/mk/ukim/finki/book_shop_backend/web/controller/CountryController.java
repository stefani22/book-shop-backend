package mk.ukim.finki.book_shop_backend.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.book_shop_backend.model.dto.CreateCountryDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayCountryDto;
import mk.ukim.finki.book_shop_backend.service.domain.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll() {
        return ResponseEntity.ok(DisplayCountryDto.from(countryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return countryService.findById(id)
                .map(DisplayCountryDto::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> create(@RequestBody @Valid CreateCountryDto dto) {
        return ResponseEntity.ok(DisplayCountryDto.from(countryService.create(dto.toCountry())));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayCountryDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateCountryDto dto) {
        return countryService.update(id, dto.toCountry())
                .map(DisplayCountryDto::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayCountryDto> deleteById(@PathVariable Long id) {
        return countryService.deleteById(id)
                .map(DisplayCountryDto::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}