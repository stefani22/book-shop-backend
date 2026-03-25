package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.domain.BookActivity;

import java.time.LocalDateTime;

public record DisplayBookActivityDto(
        Long id,
        String bookName,
        String eventType,
        LocalDateTime createdAt
) {
    public static DisplayBookActivityDto from(BookActivity activity) {
        return new DisplayBookActivityDto(
                activity.getId(),
                activity.getBookName(),
                activity.getEventType(),
                activity.getCreatedAt()
        );
    }
}