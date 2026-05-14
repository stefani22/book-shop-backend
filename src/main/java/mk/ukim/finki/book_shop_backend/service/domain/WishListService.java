package mk.ukim.finki.book_shop_backend.service.domain;

import mk.ukim.finki.book_shop_backend.model.domain.WishList;

public interface WishListService {
    WishList getOrCreate(String username);
    WishList addBook(String username, Long bookId);
    WishList removeBook(String username, Long bookId);
}