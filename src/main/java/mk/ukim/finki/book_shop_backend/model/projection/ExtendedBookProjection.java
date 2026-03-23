package mk.ukim.finki.book_shop_backend.model.projection;

import mk.ukim.finki.book_shop_backend.model.enumeration.Category;
import mk.ukim.finki.book_shop_backend.model.enumeration.State;

public interface ExtendedBookProjection {
    Long getId();
    String getName();
    Category getCategory();
    State getState();
    int getAvailableCopies();

    String getAuthorName();
    String getAuthorSurname();
    String getAuthorCountryName();
}