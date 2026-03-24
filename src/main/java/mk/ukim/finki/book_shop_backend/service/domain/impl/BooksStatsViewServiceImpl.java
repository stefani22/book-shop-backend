package mk.ukim.finki.book_shop_backend.service.domain.impl;

import mk.ukim.finki.book_shop_backend.model.views.BooksStatsView;
import mk.ukim.finki.book_shop_backend.repository.BooksStatsViewRepository;
import mk.ukim.finki.book_shop_backend.service.domain.BooksStatsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksStatsViewServiceImpl implements BooksStatsViewService {

    private final BooksStatsViewRepository repository;

    public BooksStatsViewServiceImpl(BooksStatsViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BooksStatsView> findAll() {
        return repository.findAll();
    }
}