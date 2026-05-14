package mk.ukim.finki.book_shop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
public class BookShopBackendApplication {


	public static void main(String[] args) {

		System.out.println(new BCryptPasswordEncoder().encode("admin"));
		SpringApplication.run(BookShopBackendApplication.class, args);
	}

}
