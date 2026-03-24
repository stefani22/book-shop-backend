package mk.ukim.finki.book_shop_backend.service.application.impl;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBooksStatsDto;
import mk.ukim.finki.book_shop_backend.service.application.BooksStatsViewApplicationService;
import mk.ukim.finki.book_shop_backend.service.domain.BooksStatsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksStatsViewApplicationServiceImpl implements BooksStatsViewApplicationService {

    private final BooksStatsViewService domainService;

    public BooksStatsViewApplicationServiceImpl(BooksStatsViewService domainService) {
        this.domainService = domainService;
    }

    @Override
    public List<DisplayBooksStatsDto> findAll() {
        return DisplayBooksStatsDto.from(domainService.findAll());
    }
}