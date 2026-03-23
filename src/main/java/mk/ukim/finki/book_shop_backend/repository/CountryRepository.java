package mk.ukim.finki.book_shop_backend.repository;

import mk.ukim.finki.book_shop_backend.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
