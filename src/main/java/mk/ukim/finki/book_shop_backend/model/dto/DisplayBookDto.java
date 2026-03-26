package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.domain.Book;

import java.time.LocalDate;
import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        String state,
        String category,
        int availableCopies,
        Long authorId,
        String authorName,
        String authorSurname,
        LocalDate datePublished
) {

    public static DisplayBookDto from(Book book){
        var author = book.getAuthor();
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getState().name(),
                book.getCategory().name(),
                book.getAvailableCopies(),
                author != null ? author.getId() : null,
                author != null ? author.getName() : null,
                author != null ? author.getSurname() : null,
                book.getDatePublished()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books){
        return books.stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}