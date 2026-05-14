package mk.ukim.finki.book_shop_backend.service.domain.impl;

import mk.ukim.finki.book_shop_backend.model.domain.Book;
import mk.ukim.finki.book_shop_backend.model.domain.User;
import mk.ukim.finki.book_shop_backend.model.domain.WishList;
import mk.ukim.finki.book_shop_backend.repository.BookRepository;
import mk.ukim.finki.book_shop_backend.repository.UserRepository;
import mk.ukim.finki.book_shop_backend.repository.WishListRepository;
import mk.ukim.finki.book_shop_backend.service.domain.WishListService;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public WishListServiceImpl(WishListRepository wishListRepository,
                               UserRepository userRepository,
                               BookRepository bookRepository) {
        this.wishListRepository = wishListRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public WishList getOrCreate(String username) {
        return wishListRepository.findByUserUsername(username)
                .orElseGet(() -> {
                    User user = userRepository.findByUsername(username).orElseThrow();
                    return wishListRepository.save(new WishList(user));
                });
    }

    @Override
    public WishList addBook(String username, Long bookId) {
        WishList wishList = getOrCreate(username);
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (!wishList.getBooks().contains(book)) {
            wishList.getBooks().add(book);
            wishListRepository.save(wishList);
        }
        return wishList;
    }

    @Override
    public WishList removeBook(String username, Long bookId) {
        WishList wishList = getOrCreate(username);
        Book book = bookRepository.findById(bookId).orElseThrow();
        wishList.getBooks().remove(book);
        wishListRepository.save(wishList);
        return wishList;
    }
}