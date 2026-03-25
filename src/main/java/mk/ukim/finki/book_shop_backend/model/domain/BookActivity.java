package mk.ukim.finki.book_shop_backend.model.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "book_activities")
public class BookActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private String eventType;

    private LocalDateTime createdAt;

    public BookActivity(String bookName, String eventType) {
        this.bookName = bookName;
        this.eventType = eventType;
        this.createdAt = LocalDateTime.now();
    }

    public BookActivity() {}
}