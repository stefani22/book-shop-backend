package mk.ukim.finki.book_shop_backend.service.application;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookActivityDto;
import org.springframework.data.domain.Page;

public interface BookActivityApplicationService {
    Page<DisplayBookActivityDto> findAll(int page, int size);
}