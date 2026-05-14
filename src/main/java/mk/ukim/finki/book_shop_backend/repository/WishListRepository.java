package mk.ukim.finki.book_shop_backend.repository;

import mk.ukim.finki.book_shop_backend.model.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    Optional<WishList> findByUserUsername(String username);
}