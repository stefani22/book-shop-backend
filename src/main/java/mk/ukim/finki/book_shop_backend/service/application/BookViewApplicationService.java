package mk.ukim.finki.book_shop_backend.service.application;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookViewDto;

import java.util.List;

public interface BookViewApplicationService {
    List<DisplayBookViewDto> findAll();
}
