package mk.ukim.finki.book_shop_backend.service.domain.impl;

import mk.ukim.finki.book_shop_backend.model.domain.Book;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;
import mk.ukim.finki.book_shop_backend.repository.BookRepository;
import mk.ukim.finki.book_shop_backend.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository
                .findById(id)
                .map((existingBook) -> {
                    existingBook.setName(book.getName());
                    existingBook.setState(book.getState());
                    existingBook.setCategory(book.getCategory());
                    existingBook.setAvailableCopies(book.getAvailableCopies());
                    existingBook.setAuthor(book.getAuthor());
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(bookRepository::delete);
        return book;
    }

    @Override
    public Book borrowBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if(book.getState() == State.BAD){
            throw new RuntimeException("Book is not in good condition");
        }

        if(book.getAvailableCopies() <= 0){
            throw new RuntimeException("No available copies");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        return bookRepository.save(book);
    }
}
