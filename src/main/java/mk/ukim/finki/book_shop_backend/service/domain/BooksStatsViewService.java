package mk.ukim.finki.book_shop_backend.service.domain;

import mk.ukim.finki.book_shop_backend.model.views.BooksStatsView;
import java.util.List;

public interface BooksStatsViewService {
    List<BooksStatsView> findAll();
}