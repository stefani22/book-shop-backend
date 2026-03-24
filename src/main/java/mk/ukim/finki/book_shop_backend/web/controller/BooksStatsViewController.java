package mk.ukim.finki.book_shop_backend.web.controller;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBooksStatsDto;
import mk.ukim.finki.book_shop_backend.service.application.BooksStatsViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books-stats")
public class BooksStatsViewController {

    private final BooksStatsViewApplicationService applicationService;

    public BooksStatsViewController(BooksStatsViewApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayBooksStatsDto>> findAll() {
        return ResponseEntity.ok(applicationService.findAll());
    }
}