package Restaurant.Restaurant.Restaurant.service;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantService {

    public void addRestaurant(Restaurant restaurant);

    public List<Restaurant> getAll();

    public Restaurant getByname(String name);

    public void editRestaurant(Restaurant restaurant);

    public void removeRestaurant(Long id);

    public Optional<Restaurant> getById(Long id);

}
