package mk.ukim.finki.book_shop_backend.web.controller;

import mk.ukim.finki.book_shop_backend.model.domain.User;
import mk.ukim.finki.book_shop_backend.model.dto.LoginDto;
import mk.ukim.finki.book_shop_backend.model.dto.RegisterDto;
import mk.ukim.finki.book_shop_backend.repository.UserRepository;
import mk.ukim.finki.book_shop_backend.security.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
        );
        return jwtService.generateToken(dto.username());
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto dto) {
        User user = new User(
                dto.username(),
                passwordEncoder.encode(dto.password()),
                dto.role()
        );
        userRepository.save(user);
        return jwtService.generateToken(dto.username());
    }
}