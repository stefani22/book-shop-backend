package mk.ukim.finki.book_shop_backend.events;

public record BookBorrowedEvent(Long bookId, String bookName, Long userId) {
}