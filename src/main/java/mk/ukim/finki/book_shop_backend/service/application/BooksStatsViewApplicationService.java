package mk.ukim.finki.book_shop_backend.service.application;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBooksStatsDto;

import java.util.List;

public interface BooksStatsViewApplicationService {
    List<DisplayBooksStatsDto> findAll();
}