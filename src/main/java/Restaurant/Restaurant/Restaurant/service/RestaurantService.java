package Restaurant.Restaurant.Restaurant.service;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RestaurantService {

    public void addRestaurant(Restaurant restaurant);

    public List<Restaurant> getAll();

    public Restaurant getByname(String name);

}
