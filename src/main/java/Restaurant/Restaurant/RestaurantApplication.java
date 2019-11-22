package Restaurant.Restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("Restaurant.Restaurant.User")
@ComponentScan("Restaurant.Restaurant.Dish")
@ComponentScan("Restaurant.Restaurant.Restaurant")
@ComponentScan("Restaurant.Restaurant.Config")
@ComponentScan("Restaurant.Restaurant.Order")
@ComponentScan("Restaurant.Restaurant.Cart")
@EnableWebMvc
public class RestaurantApplication {


	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
}
