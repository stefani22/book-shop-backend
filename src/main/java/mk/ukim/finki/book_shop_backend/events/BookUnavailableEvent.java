package mk.ukim.finki.book_shop_backend.events;

public record BookUnavailableEvent(Long bookId, String bookName) {
}