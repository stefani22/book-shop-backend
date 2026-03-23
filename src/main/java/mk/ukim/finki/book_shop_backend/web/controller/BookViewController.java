package mk.ukim.finki.book_shop_backend.web.controller;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookViewDto;
import mk.ukim.finki.book_shop_backend.service.application.BookViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-view")
public class BookViewController {

    private final BookViewApplicationService bookViewApplicationService;

    public BookViewController(BookViewApplicationService bookViewApplicationService) {
        this.bookViewApplicationService = bookViewApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayBookViewDto>> findAll() {
        return ResponseEntity.ok(bookViewApplicationService.findAll());
    }
}