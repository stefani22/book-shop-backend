package mk.ukim.finki.book_shop_backend.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.book_shop_backend.model.dto.CreateAuthorDto;
import mk.ukim.finki.book_shop_backend.model.dto.CreateBookDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayAuthorDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookDto;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;
import mk.ukim.finki.book_shop_backend.model.projection.ExtendedBookProjection;
import mk.ukim.finki.book_shop_backend.model.projection.ShortBookProjection;
import mk.ukim.finki.book_shop_backend.service.application.AuthorApplicationService;
import mk.ukim.finki.book_shop_backend.service.application.BookApplicationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id){
        return bookApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll() {
        return ResponseEntity.ok(bookApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> create(@RequestBody @Valid CreateBookDto createBookDto) {
        return ResponseEntity.ok(bookApplicationService.create(createBookDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody CreateBookDto createBookDto
    ) {
        return bookApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBookDto> deleteById(@PathVariable Long id) {
        return bookApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/borrow")
    public ResponseEntity<DisplayBookDto> borrowBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookApplicationService.borrowBook(id));
    }


    @GetMapping("/all")
    public ResponseEntity<Page<DisplayBookDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(bookApplicationService.findAll(page, size, sortBy));
    }

    @GetMapping("/by-category")
    public ResponseEntity<Page<DisplayBookDto>> findByCategory(
            @RequestParam Category category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(bookApplicationService.findAllByCategory(category, page, size, sortBy));
    }

    @GetMapping("/by-state")
    public ResponseEntity<Page<DisplayBookDto>> findByState(
            @RequestParam State state,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(bookApplicationService.findAllByState(state, page, size, sortBy));
    }

    @GetMapping("/by-author")
    public ResponseEntity<Page<DisplayBookDto>> findByAuthor(
            @RequestParam Long authorId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(bookApplicationService.findAllByAuthor(authorId, page, size, sortBy));
    }

    @GetMapping("/available")
    public ResponseEntity<Page<DisplayBookDto>> findAvailable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(bookApplicationService.findAllAvailable(page, size, sortBy));
    }

    // projection
    @GetMapping("/short")
    public ResponseEntity<Page<ShortBookProjection>> getShortBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(
                bookApplicationService.findAllShort(page, size, sortBy)
        );
    }

    @GetMapping("/short/by-category")
    public ResponseEntity<Page<ShortBookProjection>> getShortBooksByCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(
                bookApplicationService.findAllByCategoryShort(category, page, size, sortBy)
        );
    }

    @GetMapping("/extended")
    public ResponseEntity<Page<ExtendedBookProjection>> getExtendedBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(
                bookApplicationService.findAllExtended(page, size, sortBy)
        );
    }

    @GetMapping("/top10byDatePublished")
    public ResponseEntity<List<DisplayBookDto>> findLatest() {
        return ResponseEntity.ok(bookApplicationService.findTop10Latest());
    }

}


