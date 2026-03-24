package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.views.BooksStatsView;

import java.util.List;

public record DisplayBooksStatsDto(
        String category,
        Long totalBooks,
        Long totalAvailableCopies,
        Long badConditionBooks
) {
    public static DisplayBooksStatsDto from(BooksStatsView stats) {
        return new DisplayBooksStatsDto(
                stats.getCategory(),
                stats.getTotalBooks(),
                stats.getTotalAvailableCopies(),
                stats.getBadConditionBooks()
        );
    }

    public static List<DisplayBooksStatsDto> from(List<BooksStatsView> statsList) {
        return statsList.stream().map(DisplayBooksStatsDto::from).toList();
    }
}