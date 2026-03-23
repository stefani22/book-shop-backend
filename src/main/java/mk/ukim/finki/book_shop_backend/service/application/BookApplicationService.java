package mk.ukim.finki.book_shop_backend.service.application;

import mk.ukim.finki.book_shop_backend.model.dto.CreateBookDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookDto;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;
import mk.ukim.finki.book_shop_backend.model.projection.ExtendedBookProjection;
import mk.ukim.finki.book_shop_backend.model.projection.ShortBookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookApplicationService {
    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findAll();

    DisplayBookDto create(CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);

    DisplayBookDto borrowBook(Long id);

    Page<DisplayBookDto> findAll(
            int page,
            int size,
            String sortBy
    );

    // Metodi za filriranje
    Page<DisplayBookDto> findAllByCategory(Category category, int page, int size, String sortBy);

    Page<DisplayBookDto> findAllByState(State state, int page, int size, String sortBy);

    Page<DisplayBookDto> findAllByAuthor(Long authorId, int page, int size, String sortBy);

    Page<DisplayBookDto> findAllAvailable(int page, int size, String sortBy);

    // projection
    Page<ShortBookProjection> findAllShort(int page, int size, String sortBy);
    Page<ShortBookProjection> findAllByCategoryShort(String category, int page, int size, String sortBy);
    Page<ExtendedBookProjection> findAllExtended(int page, int size, String sortBy);

}
