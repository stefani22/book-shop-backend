package mk.ukim.finki.book_shop_backend.web.controller;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookActivityDto;
import mk.ukim.finki.book_shop_backend.service.application.BookActivityApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
public class BookActivityController {

    private final BookActivityApplicationService service;

    public BookActivityController(BookActivityApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<DisplayBookActivityDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(service.findAll(page, size));
    }
}