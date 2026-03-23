package mk.ukim.finki.book_shop_backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import mk.ukim.finki.book_shop_backend.model.domain.Author;
import mk.ukim.finki.book_shop_backend.model.domain.Book;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;

public record CreateBookDto(
        @NotBlank(message = "Book name is required")
        String name,
        Category category,
        Long authorId,
        State state,
        @Positive(message = "Available copies must be positive")
        int availableCopies
) {
    public Book toBook(Author author){
        return new Book(author, availableCopies, category, name, state);
    }
}
