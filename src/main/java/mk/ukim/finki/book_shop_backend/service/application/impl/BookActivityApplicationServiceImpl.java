package mk.ukim.finki.book_shop_backend.service.application.impl;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookActivityDto;
import mk.ukim.finki.book_shop_backend.service.application.BookActivityApplicationService;
import mk.ukim.finki.book_shop_backend.service.domain.BookActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookActivityApplicationServiceImpl implements BookActivityApplicationService {

    private final BookActivityService service;

    public BookActivityApplicationServiceImpl(BookActivityService service) {
        this.service = service;
    }

    @Override
    public Page<DisplayBookActivityDto> findAll(int page, int size) {
        return service.findAll(PageRequest.of(page, size))
                .map(DisplayBookActivityDto::from);
    }
}