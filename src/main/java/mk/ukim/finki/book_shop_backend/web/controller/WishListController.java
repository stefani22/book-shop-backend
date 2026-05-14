package mk.ukim.finki.book_shop_backend.web.controller;

import mk.ukim.finki.book_shop_backend.model.dto.DisplayWishListDto;
import mk.ukim.finki.book_shop_backend.service.domain.WishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping
    public ResponseEntity<DisplayWishListDto> getWishList(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(DisplayWishListDto.from(wishListService.getOrCreate(username)));
    }

    @PostMapping("/add/{bookId}")
    public ResponseEntity<DisplayWishListDto> addBook(
            @PathVariable Long bookId,
            Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(DisplayWishListDto.from(wishListService.addBook(username, bookId)));
    }

    @DeleteMapping("/remove/{bookId}")
    public ResponseEntity<DisplayWishListDto> removeBook(
            @PathVariable Long bookId,
            Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(DisplayWishListDto.from(wishListService.removeBook(username, bookId)));
    }
}