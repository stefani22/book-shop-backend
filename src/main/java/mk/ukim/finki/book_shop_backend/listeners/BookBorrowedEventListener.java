package mk.ukim.finki.book_shop_backend.listeners;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.book_shop_backend.events.BookBorrowedEvent;
import mk.ukim.finki.book_shop_backend.model.domain.BookActivity;
import mk.ukim.finki.book_shop_backend.repository.BookActivityRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class BookBorrowedEventListener {

    private final BookActivityRepository repository;

    public BookBorrowedEventListener(BookActivityRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void onBookBorrowed(BookBorrowedEvent event) {

        log.info("Book borrowed: {}", event.bookName());

        BookActivity activity = new BookActivity(
                event.bookName(),
                "BOOK_BORROWED"
        );

        repository.save(activity);
    }
}