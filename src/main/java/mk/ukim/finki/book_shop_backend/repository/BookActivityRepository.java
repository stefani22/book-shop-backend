package mk.ukim.finki.book_shop_backend.repository;

import mk.ukim.finki.book_shop_backend.model.domain.BookActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookActivityRepository extends JpaRepository<BookActivity, Long> {
}
