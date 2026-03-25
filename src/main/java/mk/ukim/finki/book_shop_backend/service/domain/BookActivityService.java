package mk.ukim.finki.book_shop_backend.service.domain;

import mk.ukim.finki.book_shop_backend.model.domain.BookActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookActivityService {
    Page<BookActivity> findAll(Pageable pageable);
}