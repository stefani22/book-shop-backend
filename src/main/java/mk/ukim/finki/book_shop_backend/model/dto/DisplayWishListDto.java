package mk.ukim.finki.book_shop_backend.model.dto;

import mk.ukim.finki.book_shop_backend.model.domain.WishList;
import mk.ukim.finki.book_shop_backend.model.dto.DisplayBookDto;

import java.util.List;

public record DisplayWishListDto(
        Long id,
        List<DisplayBookDto> books
) {
    public static DisplayWishListDto from(WishList wishList) {
        return new DisplayWishListDto(
                wishList.getId(),
                DisplayBookDto.from(wishList.getBooks())
        );
    }
}