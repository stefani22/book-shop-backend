package mk.ukim.finki.book_shop_backend.jobs;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.book_shop_backend.repository.BooksStatsViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BooksStatsViewRefreshScheduler {

    private final BooksStatsViewRepository booksStatsViewRepository;

    public BooksStatsViewRefreshScheduler(BooksStatsViewRepository booksStatsViewRepository) {
        this.booksStatsViewRepository = booksStatsViewRepository;
    }

    // Се извршува на секои 5 минути (пример)
    @Scheduled(cron = "0 */5 * * * *")
    @Transactional
    public void refreshBooksStatsMaterializedView() {
        log.info("Refreshing BOOKS_STATS_MV materialized view...");
        booksStatsViewRepository.refresh();
        log.info("BOOKS_STATS_MV successfully refreshed.");
    }
}