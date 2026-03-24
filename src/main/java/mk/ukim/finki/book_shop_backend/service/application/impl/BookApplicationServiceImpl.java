package mk.ukim.finki.book_shop_backend.service.application.impl;

import mk.ukim.finki.book_shop_backend.model.domain.Author;
import mk.ukim.finki.book_shop_backend.model.dto.CreateBookDto;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookDto;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;
import mk.ukim.finki.book_shop_backend.model.exception.AuthorNotFoundException;
import mk.ukim.finki.book_shop_backend.model.projection.ExtendedBookProjection;
import mk.ukim.finki.book_shop_backend.model.projection.ShortBookProjection;
import mk.ukim.finki.book_shop_backend.repository.BookRepository;
import mk.ukim.finki.book_shop_backend.service.application.BookApplicationService;
import mk.ukim.finki.book_shop_backend.service.domain.AuthorService;
import mk.ukim.finki.book_shop_backend.service.domain.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BookRepository bookRepository;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookRepository=bookRepository;
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id).map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookService.findAll());
    }

    @Override
    public DisplayBookDto create(CreateBookDto createBookDto) {
        Author author = authorService
                .findById(createBookDto.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(createBookDto.authorId()));
        return DisplayBookDto.from(bookService.create(createBookDto.toBook(author)));
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto) {
        Author author = authorService
                .findById(createBookDto.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(createBookDto.authorId()));
        return bookService
                .update(id, createBookDto.toBook(author))
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> deleteById(Long id) {
        return bookService.deleteById(id).map(DisplayBookDto::from);
    }

    @Override
    public DisplayBookDto borrowBook(Long id){

        return DisplayBookDto.from(bookService.borrowBook(id));
    }



    @Override
    public Page<DisplayBookDto> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return bookRepository.findAll(pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public Page<DisplayBookDto> findAllByCategory(Category category, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return bookRepository.findByCategory(category, pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public Page<DisplayBookDto> findAllByState(State state, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return bookRepository.findByState(state, pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public Page<DisplayBookDto> findAllByAuthor(Long authorId, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return bookRepository.findByAuthorId(authorId, pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public Page<DisplayBookDto> findAllAvailable(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return bookRepository.findByAvailableCopiesGreaterThan(0, pageable)
                .map(DisplayBookDto::from);
    }



    @Override
    public Page<ShortBookProjection> findAllShort(int page, int size, String sortBy) {
        return bookRepository.findAllShort(
                PageRequest.of(page, size, Sort.by(sortBy).ascending())
        );
    }

    @Override
    public Page<ShortBookProjection> findAllByCategoryShort(String category, int page, int size, String sortBy) {
        return bookRepository.findAllByCategoryShort(
                category,
                PageRequest.of(page, size, Sort.by(sortBy).ascending())
        );
    }

    @Override
    public Page<ExtendedBookProjection> findAllExtended(int page, int size, String sortBy) {
        return bookRepository.findAllProjectedBy(
                PageRequest.of(page, size, Sort.by(sortBy).ascending())
        );
    }



}
