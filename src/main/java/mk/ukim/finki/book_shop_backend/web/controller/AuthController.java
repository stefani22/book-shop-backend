package mk.ukim.finki.book_shop_backend.web.controller;


import mk.ukim.finki.book_shop_backend.model.dto.LoginDto;
import mk.ukim.finki.book_shop_backend.security.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto dto) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
            );
        } catch (Exception e) {
            System.out.println("LOGIN FAILED: " + e.getMessage());
            throw e;
        }

        return jwtService.generateToken(dto.username());
    }
}
