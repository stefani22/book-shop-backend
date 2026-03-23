package mk.ukim.finki.book_shop_backend.service.application.impl;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookViewDto;
import mk.ukim.finki.book_shop_backend.repository.BookViewRepository;
import mk.ukim.finki.book_shop_backend.service.application.BookViewApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookViewApplicationServiceImpl implements BookViewApplicationService {

    private final BookViewRepository bookViewRepository;

    public BookViewApplicationServiceImpl(BookViewRepository bookViewRepository) {
        this.bookViewRepository = bookViewRepository;
    }

    @Override
    public List<DisplayBookViewDto> findAll() {
        return DisplayBookViewDto.from(bookViewRepository.findAll());
    }
}