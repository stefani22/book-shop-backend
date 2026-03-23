package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.views.BookView;

import java.util.List;

public record DisplayBookViewDto(
        Long id,
        String name,
        String category,
        String state,
        Integer availableCopies,
        String authorFullName,
        String countryName
) {
    public static DisplayBookViewDto from(BookView view) {
        return new DisplayBookViewDto(
                view.getId(),
                view.getName(),
                view.getCategory(),
                view.getState(),
                view.getAvailableCopies(),
                view.getAuthorFullName(),
                view.getCountryName()
        );
    }

    public static List<DisplayBookViewDto> from(List<BookView> views) {
        return views.stream().map(DisplayBookViewDto::from).toList();
    }
}