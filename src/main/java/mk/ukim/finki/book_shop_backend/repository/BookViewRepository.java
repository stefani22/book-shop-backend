package mk.ukim.finki.book_shop_backend.repository;

import mk.ukim.finki.book_shop_backend.model.views.BookView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookViewRepository extends JpaRepository<BookView, Long> {
}