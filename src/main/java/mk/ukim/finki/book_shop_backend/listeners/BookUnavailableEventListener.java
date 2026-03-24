package mk.ukim.finki.book_shop_backend.listeners;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.book_shop_backend.events.BookUnavailableEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookUnavailableEventListener {

    @EventListener
    public void onBookUnavailable(BookUnavailableEvent event) {
        log.warn("Book '{}' (id: {}) is now unavailable!", event.bookName(), event.bookId());

        //plus potoa moze da se zapise vo nova tabela za nedostapni knigi
    }
}