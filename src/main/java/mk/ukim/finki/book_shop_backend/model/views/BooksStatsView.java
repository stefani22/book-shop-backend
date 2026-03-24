package mk.ukim.finki.book_shop_backend.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "books_stats_mv")
public class BooksStatsView {

    @Id
    private String category;

    private Long totalBooks;

    private Long totalAvailableCopies;

    private Long badConditionBooks;
}