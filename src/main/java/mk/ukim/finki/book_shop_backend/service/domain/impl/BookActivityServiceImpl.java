package mk.ukim.finki.book_shop_backend.service.domain.impl;

import mk.ukim.finki.book_shop_backend.model.domain.BookActivity;
import mk.ukim.finki.book_shop_backend.repository.BookActivityRepository;
import mk.ukim.finki.book_shop_backend.service.domain.BookActivityService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class BookActivityServiceImpl implements BookActivityService {

    private final BookActivityRepository repository;

    public BookActivityServiceImpl(BookActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<BookActivity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}