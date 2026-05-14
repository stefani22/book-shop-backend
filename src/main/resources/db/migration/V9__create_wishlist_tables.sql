CREATE TABLE wishlists (
                           id BIGSERIAL PRIMARY KEY,
                           user_id BIGINT UNIQUE REFERENCES users(id)
);

CREATE TABLE wishlist_books (
                                wishlist_id BIGINT REFERENCES wishlists(id),
                                book_id BIGINT REFERENCES books(id),
                                PRIMARY KEY (wishlist_id, book_id)
);