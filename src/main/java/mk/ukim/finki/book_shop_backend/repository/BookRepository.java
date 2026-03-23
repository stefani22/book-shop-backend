package mk.ukim.finki.book_shop_backend.repository;

import mk.ukim.finki.book_shop_backend.model.domain.Book;
import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;
import mk.ukim.finki.book_shop_backend.model.projection.ExtendedBookProjection;
import mk.ukim.finki.book_shop_backend.model.projection.ShortBookProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface BookRepository extends JpaRepository<Book, Long> {

    // Filters + pagination
    Page<Book> findByCategory(Category category, Pageable pageable);
    Page<Book> findByState(State state, Pageable pageable);
    Page<Book> findByAuthorId(Long authorId, Pageable pageable);
    Page<Book> findByAvailableCopiesGreaterThan(int copies, Pageable pageable);
    //Page<Book> findByCategoryAndState(Category category, State state, Pageable pageable);

    // Short projection i pagination
    @Query(value = "SELECT id, name, category, state, available_copies AS availableCopies FROM books", nativeQuery = true)
    Page<ShortBookProjection> findAllShort(Pageable pageable);

    @Query(value = "SELECT id, name, category, state, available_copies AS availableCopies FROM books WHERE category = :category", nativeQuery = true)
    Page<ShortBookProjection> findAllByCategoryShort(String category, Pageable pageable);

    // Extended projection so EntityGraph i pagination
    @EntityGraph(value = "book-author-country-graph", type = EntityGraph.EntityGraphType.FETCH)
    Page<ExtendedBookProjection> findAllProjectedBy(Pageable pageable);
}