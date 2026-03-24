package mk.ukim.finki.book_shop_backend.listeners;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.book_shop_backend.events.BookBorrowedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookBorrowedEventListener {

    @EventListener
    public void onBookBorrowed(BookBorrowedEvent event) {
        log.info("Book borrowed: {} (id: {}) by user {}", event.bookName(), event.bookId(), event.userId());

    }
}