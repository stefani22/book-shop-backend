package mk.ukim.finki.book_shop_backend.model.dto;

public record RegisterDto(
        String username,
        String password,
        String role
) {}