package Restaurant.Restaurant;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan("Restaurant.Restaurant.User")
@ComponentScan("Restaurant.Restaurant.Dish")
@ComponentScan("Restaurant.Restaurant.Restaurant")
@ComponentScan("Restaurant.Restaurant.Config")
@ComponentScan("Restaurant.Restaurant.Order")
@ComponentScan
@EnableWebMvc
public class RestaurantApplication {

	public static void main(String[] args) {

		run(RestaurantApplication.class, args);
	}

}
