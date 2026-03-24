package mk.ukim.finki.book_shop_backend.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.book_shop_backend.model.views.BooksStatsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksStatsViewRepository extends JpaRepository<BooksStatsView, String> {

    @Transactional
    @Modifying
    @Query(value = "REFRESH MATERIALIZED VIEW books_stats_mv", nativeQuery = true)
    void refresh();
}